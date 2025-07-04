Coding Standards for Multi-Language Code Review
Apply To: **/*.py, **/*.js, **/*.java
General Guidelines

Ensure consistent formatting and readability across all languages.
Follow language-specific conventions unless overridden by project-specific rules.
Address medium/high-priority issues before merging.

Language-Specific Standards
1. Python (Based on PEP 8)

Indentation: Use 4 spaces per indentation level; avoid tabs.
Line Length: Maximum 79 characters (72 for docstrings/comments).
Whitespace: Surround operators with single spaces (e.g., x = 1); no spaces around = in default arguments (e.g., def func(x=1):).
Imports: Group at file top (standard library, third-party, local); one import per line.
Naming: snake_case for variables/functions, CamelCase for classes, UPPER_SNAKE_CASE for constants.
Comments: Use # for block comments; """ for docstrings with purpose, params, and returns.

2. JavaScript (Based on ESLint Best Practices)

Indentation: Use 2 spaces per indentation level.
Line Length: Maximum 100 characters.
Whitespace: Use single spaces around operators (e.g., let x = 1 + 2); no trailing spaces.
Semicolons: Optional but consistent (prefer omitting where safe).
Naming: camelCase for variables/functions, PascalCase for classes, UPPER_CASE for constants.
Imports: Use ES6 modules with consistent ordering (e.g., import statements grouped).
Comments: Use // for single-line, /* */ for multi-line; avoid redundant comments.

3. Java (Based on Oracle Java Code Conventions)

Indentation: Use 4 spaces per indentation level; no tabs.
Line Length: Maximum 80 characters.
Whitespace: Single space after keywords (e.g., if (condition)); no spaces inside parentheses.
Braces: Use Allman style (braces on new line) for blocks.
Naming: camelCase for variables/methods, PascalCase for classes, UPPER_CASE for constants.
Comments: Use // for inline, /* */ for block; Javadoc for public methods/classes.

Review Guidelines

Review Metrics: Provide an overall score (0-100), files reviewed, and total issues.
Issue Breakdown: Categorize issues by priority (e.g., Medium: indentation issues).
Recommendations: Suggest fixes based on the above standards.
Next Steps: Review inline comments, address issues, and push updates for re-review.

Example Issues

File: script.py, Line: 5, Issue: PEP 8 violation: Use 4 spaces for indentation.
File: app.js, Line: 10, Issue: Line exceeds 100 characters.
File: Main.java, Line: 3, Issue: Missing Javadoc for public method.
