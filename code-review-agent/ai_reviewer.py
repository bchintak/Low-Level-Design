
import os
import json
from openai import OpenAI


class AIReviewer:

    def __init__(self):
        self.client = OpenAI(
            api_key=os.environ["OPENAI_API_KEY"]
        )

        self.model = os.getenv(
            "OPENAI_MODEL", "gpt-4.1-mini"
        )

    def review_file(self, filename, content, patch):

        prompt = f"""
You are a Senior Java Developer and Software Architect.

Review this Java Pull Request change.

FILE: {filename}

FULL FILE CONTENT:
{content}

PULL REQUEST DIFF:
{patch}

Check for:
1. Java syntax and compilation problems.
2. Null pointer exceptions.
3. Incorrect exception handling.
4. SOLID violations.
5. Incorrect OOP design.
6. Design pattern misuse.
7. Performance problems.
8. Memory leaks.
9. Concurrency issues.
10. Security vulnerabilities.
11. SQL injection.
12. Inefficient database calls.
13. Code duplication.
14. Java best practices.
15. Spring Boot best practices, if applicable.

Rules:
- Focus only on added or modified lines.
- Use line numbers from the new file.
- Report only genuine issues.
- Do not report personal preferences.
- Do not invent issues.
- Give actionable suggestions.
- Do not report the same issue twice.

Return JSON in this format:

{{
  "findings": [
    {{
      "line": 10,
      "severity": "HIGH",
      "category": "BUG",
      "title": "Potential NullPointerException",
      "description": "Explain the issue",
      "suggestion": "How to fix it"
    }}
  ]
}}

If no issues exist, return:
{{"findings": []}}
"""

        response = self.client.chat.completions.create(
            model=self.model,
            messages=[
                {
                    "role": "system",
                    "content": (
                        "You are a precise Java code reviewer. "
                        "Return valid JSON only."
                    )
                },
                {
                    "role": "user",
                    "content": prompt
                }
            ],
            response_format={"type": "json_object"},
            temperature=0
        )

        result = response.choices[0].message.content

        return json.loads(result)
