from datetime import datetime, timedelta
import pytz
from github import Github, GithubException
import logging

logger = logging.getLogger(__name__)

def check_new_prs(state: PRCheckState) -> PRCheckState:
    """
    Check for new PRs raised in the last 5 minutes.
    """
    logger.info("Entering check_new_prs")
    try:
        g = Github(state["github_token"])
        repo_name = state["repo_url"].removeprefix("https://github.com/").rstrip("/")
        repo = g.get_repo(repo_name)

        time_threshold = datetime.now(pytz.UTC) - timedelta(minutes=5)
        new_prs = [
            pr for pr in repo.get_pulls(state="open")
            if pr.created_at > time_threshold
        ]

        state["new_prs"] = [pr.number for pr in new_prs]
        logger.info(f"Found {len(new_prs)} new PRs: {state['new_prs']}")
        return state
    except GithubException as e:
        state["error"] = f"check_new_prs error: {str(e)}"
        logger.error(state["error"])
        return state

def get_pr_details(state: PRCheckState) -> PRCheckState:
    """
    Get details of new PRs, including title, files, source, and target branches.
    """
    logger.info("Entering get_pr_details")
    if state.get("error"):
        logger.warning(f"Skipping get_pr_details due to error: {state['error']}")
        return state

    try:
        g = Github(state["github_token"])
        repo_name = state["repo_url"].removeprefix("https://github.com/").rstrip("/")
        repo = g.get_repo(repo_name)

        pr_details = []
        for pr_number in state["new_prs"]:
            pr = repo.get_pull(pr_number)
            files = [file.filename for file in pr.get_files()]
            logger.info(f"PR #{pr_number}: Merging {pr.head.ref} into {pr.base.ref}")
            pr_details.append({
                "pr_number": pr_number,
                "title": pr.title,
                "has_files": len(files) > 0,
                "files": files,
                "source_branch": pr.head.ref,
                "target_branch": pr.base.ref
            })

        state["pr_details"] = pr_details
        logger.info(f"Retrieved details for {len(pr_details)} PRs")
        return state
    except GithubException as e:
        state["error"] = f"get_pr_details error: {str(e)}"
        logger.error(state["error"])
        return state

def fetch_pr_details(repo_url: str, github_token: str) -> dict:
    """
    Fetch details of new PRs raised in the last 5 minutes for a repository.
    Returns PR number, title, whether it has files, list of changed files, and branch details.
    """
    state: PRCheckState = {
        "repo_url": repo_url,
        "github_token": github_token,
        "new_prs": [],
        "pr_details": [],
        "error": None
    }

    state = check_new_prs(state)
    if state.get("error"):
        raise Exception(state["error"])

    state = get_pr_details(state)
    if state.get("error"):
        raise Exception(state["error"])

    return {"pr_details": state["pr_details"]}
