from docx import Document
from typing import List

def remove_special_contents(docs: List[str]) -> List[str]:
    switch = False
    for line in docs:
        if line.find("简答"):
            switch = True

        if switch:
            docs.pop()

    return docs

document = Document("Network security.docx")
