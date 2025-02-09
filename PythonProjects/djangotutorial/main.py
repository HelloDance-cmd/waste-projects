from docx import Document

def modify_word_document(file_path):
    doc = Document(file_path)
    for paragraph in doc.paragraphs:
        if paragraph.text.strip().startswith(("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15")):
            # 查找答案所在位置（假设答案就在括号及括号内内容之后）
            start_index = paragraph.text.find("(")
            end_index = paragraph.text.find(")")
            if start_index!= -1 and end_index!= -1:
                question_text = paragraph.text[:start_index].strip() + "\n答案" + paragraph.text[start_index + 1:end_index].replace(" ", "")
                paragraph.text = question_text
    doc.save("modified_" + file_path)

# 使用示例，将此处的'test.docx'替换为你实际的Word文档路径
modify_word_document('数据安全.docx')