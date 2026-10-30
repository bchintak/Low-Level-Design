
from github_client import GitHubClient
from ai_reviewer import AIReviewer
from diff_parser import get_added_lines


ALLOWED_SEVERITIES = {
    "CRITICAL", "HIGH", "MEDIUM", "LOW"
}


def main():

    print("Starting AI Code Review Agent...")

    github = GitHubClient()
    reviewer = AIReviewer()

    pr = github.get_pull_request()

    head_sha = pr["head"]["sha"]

    print(f"Reviewing PR #{pr['number']}")

    changed_files = github.get_changed_files()

    review_comments = []

    for file in changed_files:

        filename = file["filename"]

        if not filename.endswith(".java"):
            continue

        if file["status"] == "removed":
            continue

        patch = file.get("patch")

        if not patch:
            print(f"Skipping unavailable diff: {filename}")
            continue

        print(f"Reviewing: {filename}")

        added_lines = get_added_lines(patch)

        if not added_lines:
            continue

        try:
            content = github.get_file_content(
                filename, head_sha
            )

            findings = reviewer.review_file(
                filename, content, patch
            )

            for finding in findings.get("findings", []):

                line = finding.get("line")
                severity = finding.get(
                    "severity", "MEDIUM"
                ).upper()

                if not isinstance(line, int):
                    continue

                if line not in added_lines:
                    print(
                        f"Skipping non-added line: "
                        f"{filename}:{line}"
                    )
                    continue

                if severity not in ALLOWED_SEVERITIES:
                    continue

                title = finding.get(
                    "title", "Code review finding"
                )

                description = finding.get(
                    "description", ""
                )

                suggestion = finding.get(
                    "suggestion", ""
                )

                body = f"""**[{severity}] {title}**

**Category:** {finding.get('category', 'GENERAL')}

{description}

**Suggested fix:**
{suggestion}

---
*Automated AI Code Review*
"""

                review_comments.append({
                    "path": filename,
                    "line": line,
                    "side": "RIGHT",
                    "body": body
                })

        except Exception as error:
            print(
                f"Error reviewing {filename}: {error}"
            )

    if review_comments:

        github.publish_review(
            head_sha,
            review_comments
        )

        print(
            f"Published {len(review_comments)} "
            "review comments."
        )

    else:
        print("No actionable issues found.")

    print("AI Code Review completed.")


if __name__ == "__main__":
    main()
