Copilot Code Review Instructions
For pull request code reviews, adhere to the following guidelines based on file types:
Java Files

Apply the coding standards defined in docs/java_coding_standards.md to all files with the .java extension.
Also review Java-dependent files, such as pom.xml or build.gradle, for compliance with the same standards where applicable (e.g., proper dependency declarations, formatting).
Ignore non-Java files (e.g., .py, .js, .md) unless explicitly referenced in docs/java_coding_standards.md.

Python Files (Future Extension)

If a docs/python_coding_standards.md file is added to the repository, apply its standards only to files with the .py extension and Python-dependent files (e.g., requirements.txt, pyproject.toml).
Do not review Python files until Python-specific standards are provided.

General Instructions

Focus reviews strictly on the standards specified in the relevant coding standards file (docs/java_coding_standards.md for Java, or docs/python_coding_standards.md for Python if added).
Provide detailed comments for violations, referencing the specific standard from the respective file.
Skip files that do not match the specified extensions or dependency criteria.
