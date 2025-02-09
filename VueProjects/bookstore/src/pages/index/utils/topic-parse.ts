export interface Subtitle {
  id: number;
  title: string;
  content: string;
  chapterTitle: string | null;
}

export interface TopicResult {
  title: string; // 主题名称 放在最顶端的内容
  subtitles: Subtitle[]; // 小标题合集可能一页有好多个标题
  page: number; // 页码
}

function convertPunctuation(input: string) {
  let result = input
    .replace(/\./g, "。")
    .replace(/,/g, "，")
    .replace(/\?/g, "？")
    .replace(/!/g, "！")
    .replace(/:/g, "：")
    .replace(/;/g, "；")
    .replace(/"/g, "“")
    .replace(/'/g, "‘")
    .replace("(", "（")
    .replace(")", "）");
  return result;
}

export default class TopicParse {
  static parseTopic(topic: string): TopicResult[] | null {
    let topicList = topic.split("\n\r\n\r\n\r").map((item) => item.trim());
    let result: TopicResult[] = [];
    let last_title;

    for (let topic of topicList) {
      let lineByLine = topic.split(/\n/) as string[];

      if (lineByLine[0].indexOf("[") == -1) {
        console.log(topicList);

        throw new Error(
          "Invalid topic format, mybe missing page number or title" + lineByLine
        );
      }
      let topicDesc = lineByLine[0]
        .replace("[", "")
        .replace("]", "")
        .split("-");

      let page: number = parseInt(topicDesc[0]);
      let title: string = "* ".concat(topicDesc[1].trim()).concat(" *");

      lineByLine = lineByLine.slice(1);
      let subtitles: Subtitle[] = [];
      let idx = 0;
      let chapterTitle: string | null = null;

      for (let line of lineByLine) {
        if (line.indexOf("**") != -1) {
          chapterTitle = line.replace("**", "");
          continue;
        }

        // 加粗冒号前的字
        const toChinieseSymbol = convertPunctuation(line);
        let l = toChinieseSymbol.split("：");
        if (l[0] != toChinieseSymbol && l[0].length <= 10) {
          // 不是所有冒号前的字都需要加粗
          l[0] = "<b>" + l[0] + "</b>";
          line = l.join("：");
        } else {
          line = toChinieseSymbol;
        }

        // 替换()中的内容字体为楷体
        const reg = new RegExp(/（.*?）/);
        if (reg.test(line)) {
          const source = (reg.exec(line) as RegExpExecArray)[0];
          const replaced = source
            .replace("（", "<text style='font-family: 楷体, 宋体;'>（")
            .replace("）", "）</text>");
          line = line.replace(source, replaced);
        }

        if (line.indexOf("*") != -1) {
          let title = line.replace("*", "").trim();
          last_title = title;
          subtitles.push({
            id: Math.random(),
            title,
            content: "",
            chapterTitle: chapterTitle,
          });

          chapterTitle = null;
        } else {
          // 有标题
          if (
            subtitles.length >= 1 &&
            subtitles[subtitles.length - 1].content !== undefined
          ) {
            subtitles[subtitles.length - 1].content += "<p>"
              .concat(line)
              .concat("</p>");
          } else {
            // 没有标题，续写下一页的标题
            subtitles.push({
              id: idx,
              title: "", // 续写的下一页标题
              content: line,
              chapterTitle: null,
            });
          }
        }
      }

      result.push({
        page,
        title,
        // content,
        subtitles,
      });
    }
    return result;
  }
}
