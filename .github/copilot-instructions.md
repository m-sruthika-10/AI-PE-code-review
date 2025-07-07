Copilot Code Review Instructions
For pull request code reviews, adhere to the following guidelines based on file types and the presence of coding standards files in the repository:
Java Files

If docs/java_coding_standards.md exists, apply its coding standards to all files with the .java extension and Java-dependent files (e.g., pom.xml, build.gradle) for compliance with standards such as naming conventions, documentation, and formatting.
Ignore non-Java files (e.g., .py, .js, .md) for Java standards unless explicitly referenced in docs/java_coding_standards.md.

Python Files

If guardrails.txt exists, apply its coding standards to all files with the .py extension and Python-dependent files (e.g., requirements.txt, pyproject.toml) for compliance with standards such as naming conventions, formatting, and dependency specifications.
Ignore non-Python files (e.g., .java, .js, .md) for Python standards unless explicitly referenced in guardrails.txt.

Mixed Pull Requests

For pull requests containing both .java and .py files:
Review .java and Java-dependent files (e.g., pom.xml, build.gradle) against docs/java_coding_standards.md if it exists.
Review .py and Python-dependent files (e.g., requirements.txt, pyproject.toml) against guardrails.txt if it exists.


Ensure no overlap in standards application (e.g., do not apply Java standards to .py files or Python standards to .java files).

General Instructions

Only review files matching the specified extensions and their dependent files based on the available standards files (docs/java_coding_standards.md for Java, guardrails.txt for Python).
If only one standards file exists (e.g., docs/java_coding_standards.md but no guardrails.txt), review only the corresponding file types (e.g., .java and Java-dependent files).
Provide detailed comments for violations, referencing the specific standard from the relevant standards file.
Skip files that do not match the specified extensions or dependency criteria (e.g., .js, .md, .html).
