
import os
import base64
import requests
from urllib.parse import quote


class GitHubClient:

    def __init__(self):
        self.token = os.environ["GITHUB_TOKEN"]
        self.repo = os.environ["GITHUB_REPOSITORY"]
        self.pr_number = os.environ["PR_NUMBER"]

        self.base_url = (
            f"https://api.github.com/repos/{self.repo}"
        )

        self.headers = {
            "Authorization": f"Bearer {self.token}",
            "Accept": "application/vnd.github+json",
            "X-GitHub-Api-Version": "2022-11-28"
        }

    def get_pull_request(self):
        url = f"{self.base_url}/pulls/{self.pr_number}"

        response = requests.get(
            url, headers=self.headers, timeout=30
        )
        response.raise_for_status()

        return response.json()

    def get_changed_files(self):
        files = []
        page = 1

        while True:
            url = (
                f"{self.base_url}/pulls/"
                f"{self.pr_number}/files"
            )

            response = requests.get(
                url,
                headers=self.headers,
                params={"per_page": 100, "page": page},
                timeout=30
            )
            response.raise_for_status()

            batch = response.json()
            files.extend(batch)

            if len(batch) < 100:
                break

            page += 1

        return files

    def get_file_content(self, path, commit_sha):
        encoded_path = quote(path, safe="/")

        url = (
            f"{self.base_url}/contents/"
            f"{encoded_path}"
        )

        response = requests.get(
            url,
            headers=self.headers,
            params={"ref": commit_sha},
            timeout=30
        )
        response.raise_for_status()

        data = response.json()

        if data.get("encoding") != "base64":
            raise ValueError(
                f"Unsupported file encoding: {path}"
            )

        return base64.b64decode(
            data["content"]
        ).decode("utf-8")

    def publish_review(self, commit_sha, comments):
        url = (
            f"{self.base_url}/pulls/"
            f"{self.pr_number}/reviews"
        )

        payload = {
            "commit_id": commit_sha,
            "body": "AI Java Code Review completed.",
            "event": "COMMENT",
            "comments": comments
        }

        response = requests.post(
            url,
            headers=self.headers,
            json=payload,
            timeout=60
        )

        response.raise_for_status()
        return response.json()
