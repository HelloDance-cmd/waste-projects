import { SystemInfo } from "../utils/getSystemInfo";
import { TopicResult } from "../utils/topic-parse";

export type BackgroundColorChoice =
  | "#000000"
  | "#FAF9DE"
  | "#FFFFFF"
  | "#EBEBEB";
export type TextColorChoice = BackgroundColorChoice;
export type FontChoice = "宋体" | "微软雅黑";

export interface ReturnType {
  bookDisplayBackgroundColor: BackgroundColorChoice;
  textOfBookDisplayColor: TextColorChoice;
  display: {
    isNavShow: Boolean;
    isControlPanelShow: Boolean;
    lineHeight: Number;
    fontFamily: FontChoice;
    colorChoice: Boolean;
    fontChoice: Boolean;
    praghChoice: Boolean;
  };
  topices: TopicResult[];
  topicShow: TopicResult;
  info: SystemInfo;

  currentPage: number;
}
