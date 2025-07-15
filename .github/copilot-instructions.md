PR Review Instructions for GitHub Copilot
Overview
These instructions guide GitHub Copilot in performing code reviews for pull requests (PRs). The review must:

Apply coding standards for Java and Python files based on specified standards files.
Verify that PR changes align with the functionality described in the corresponding Jira ticket.
Provide clear, detailed feedback on compliance with coding standards and Jira ticket alignment.
Java Files
Standards Application:
If docs/java_coding_standards.md exists, apply its coding standards to all files with the .java extension and Java-dependent files (e.g., pom.xml, build.gradle) for compliance with naming conventions, documentation, formatting, and other specified standards.
Ignore non-Java files (e.g., .py, .js, .md) unless explicitly referenced in docs/java_coding_standards.md.
Review Process:
Identify violations of standards and provide detailed comments referencing the specific standard from docs/java_coding_standards.md.
Example: "Variable user_name violates naming convention in docs/java_coding_standards.md (Section 2.1: Use camelCase for variable names). Rename to userName."
Python Files
Standards Application:
If guardrails.txt exists, apply its coding standards to all files with the .py extension and Python-dependent files (e.g., requirements.txt, pyproject.toml) for compliance with naming conventions, formatting, dependency specifications, and other specified standards.
Ignore non-Python files (e.g., .java, .js, .md) unless explicitly referenced in guardrails.txt.
Review Process:
Identify violations of standards and provide detailed comments referencing the specific standard from guardrails.txt.
Example: "Function process_data lacks docstring, violating guardrails.txt (Section 3.2: All functions must have docstrings). Add a docstring describing functionality."
Mixed Pull Requests
For PRs containing both .java and .py files:
Review .java and Java-dependent files (e.g., pom.xml, build.gradle) against docs/java_coding_standards.md if it exists.
Review .py and Python-dependent files (e.g., requirements.txt, pyproject.toml) against guardrails.txt if it exists.
Ensure no overlap in standards application (e.g., do not apply Java standards to .py files or Python standards to .java files).
General Instructions
Only review files matching the specified extensions (.java, .py) and their dependent files (e.g., pom.xml, requirements.txt) based on the available standards files (docs/java_coding_standards.md for Java, guardrails.txt for Python).
If only one standards file exists (e.g., docs/java_coding_standards.md but no guardrails.txt), review only the corresponding file types (e.g., .java and Java-dependent files).
Skip files that do not match the specified extensions or dependency criteria (e.g., .js, .md, .html).
Provide detailed, actionable comments for all violations, referencing the specific standard or rule.
Jira Feature Check
Jira Ticket Details:
For each PR, locate the corresponding Jira ticket details in the .github directory, stored in files named jira-ticket-details-<TICKET_ID>.txt (e.g., .github/jira-ticket-details-APB-6.txt).
Review Process:
Compare the PR changes (code, configuration, and documentation) against the summary and description in the corresponding jira-ticket-details-<TICKET_ID>.txt file.
Verify that the PR implements only the functionality described in the Jira ticket.
Identify and flag any changes that are unrelated to or exceed the scope of the Jira ticket’s summary and description.
Feedback Requirements:
Provide a clear and explicit statement at the start of the review summarizing whether the PR changes fully align with the Jira ticket description.
Example: "The PR changes fully align with the functionality described in jira-ticket-details-APB-6.txt (e.g., implementation of user authentication endpoint)."
Example: "The PR includes changes unrelated to jira-ticket-details-APB-6.txt. The addition of a logging module is outside the ticket’s scope (user authentication endpoint)."
For discrepancies, provide detailed comments referencing specific changes in the PR and the relevant parts of the Jira ticket description.
Example: "File LoggingUtil.java introduces a new logging utility, but jira-ticket-details-APB-6.txt specifies only user authentication functionality. Remove or justify this addition."
Ensure all comments are concise, actionable, and reference the specific Jira ticket ID and description details.
