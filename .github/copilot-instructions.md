Custom Instructions for GitHub Copilot
For all code reviews and coding assistance, adhere to the coding standards defined in guardrails.txt located in the root of this repository. Key standards include:

Use camelCase for variable and function names in JavaScript and TypeScript.
Define constants for all magic numbers and strings.
Follow PEP 8 for Python files, including 4-space indentation and maximum line length of 79 characters.
Ensure all public functions and methods have appropriate documentation (e.g., JSDoc for JavaScript/TypeScript, docstrings for Python).

File-Specific Instructions

For JavaScript and TypeScript files (**/*.js, **/*.ts, **/*.tsx):
Apply the naming conventions, documentation, and error handling standards from guardrails.txt.


For Python files (**/*.py):
Enforce PEP 8 compliance and other Python-specific standards from guardrails.txt.


For configuration files (e.g., **/*.json, **/*.yml):
Follow formatting and structure guidelines in guardrails.txt.



If guardrails.txt is not found or conflicts with these instructions, prioritize the standards listed here. Refer to guardrails.txt for additional details or context.
