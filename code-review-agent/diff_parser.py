
import re


def get_added_lines(patch: str) -> set[int]:
    """Return new-file line numbers added in a unified diff."""
    added_lines = set()
    current_line = None

    for line in patch.splitlines():
        if line.startswith("@@"):
            match = re.search(r"\+(\d+)(?:,\d+)?", line)
            if match:
                current_line = int(match.group(1))
            continue

        if current_line is None:
            continue

        if line.startswith("+++"):
            continue

        if line.startswith("---"):
            continue

        if line.startswith("+"):
            added_lines.add(current_line)
            current_line += 1

        elif line.startswith("-"):
            continue

        elif line.startswith("\\"):
            continue

        else:
            current_line += 1

    return added_lines
