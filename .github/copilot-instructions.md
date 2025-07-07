Copilot Code Review Instructions
For pull request code reviews, adhere to the following guidelines based on file types:
Java Files

Apply the coding standards defined in docs/java_coding_standards.md to all files with the .java extension.
Also review Java-dependent files, such as pom.xml or build.gradle, for compliance with the same standards where applicable (e.g., dependency declarations, formatting).
Ignore non-Java files (e.g., .py, .js, .md) unless explicitly referenced in docs/java_coding_standards.md.

Python Files

Apply the coding standards defined in guardrails.txt to all files with the .py extension.
Also review Python-dependent files, such as requirements.txt or pyproject.toml, for compliance with the same standards where applicable (e.g., dependency specifications, formatting).
Ignore non-Python files (e.g., .java, .js, .md) unless explicitly referenced in guardrails.txt.

General Instructions

Focus reviews strictly on the standards specified in the relevant coding standards file (docs/java_coding_standards.md for Java files, guardrails.txt for Python files).
Provide detailed comments for violations, referencing the specific standard from the respective file.
Skip files that do not match the specified extensions or dependency criteria (e.g., do not review .js or .md files).
For mixed pull requests, ensure Java files are reviewed against docs/java_coding_standards.md and Python files against guardrails.txt without overlap.
