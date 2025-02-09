export default function getSystemInfo() {
  return uni.getSystemInfoSync();
}

export interface SystemInfo {
  fontSize: number;
  textFontFamily: string;
  textFontWeight: string;

  titleFontFamily: string;
  titleFontWeight: string;
}

export function getFontConfigration(): SystemInfo {
  let info = getSystemInfo();
  console.log(info.windowHeight);
  return {
    textFontFamily: "宋体",
    fontSize: info.windowHeight * 0.0230769230769231,
    textFontWeight: "normal",

    titleFontFamily: "幼圆",
    titleFontWeight: "bold",
  };
}
