import {
  requestArticleById,
  requestArticles,
  publishArticle,
} from "./request-parts/articles";

import {
  getCommentListById,
  commitUserComment,
} from "./request-parts/comments";

import { registerPost } from "./request-parts/registe";
import { userLoggined } from "./request-parts/login";
import axios, { AxiosResponse } from "axios";
import { AboutMe } from "../types/AboutMe";

type Response<T> = Promise<AxiosResponse<T>>;

const ins = axios.create({
  headers: {
    "Content-Type": "application/json",
  },
  baseURL: "/api",
});

// TODO 这个考虑是否省去关于我的信息，因为还得在注册信息中添加
// 或者添加到我的个人中心也可以

/**
 * 获取关于此账号的信息
 * @returns
 */
const getInformationForMe = (): Response<AboutMe> => {
  return ins.get("/aboutme");
};

export { type Response, ins };
export {
  registerPost,
  requestArticles,
  requestArticleById,
  publishArticle,
  getCommentListById,
  commitUserComment,
  getInformationForMe,
  userLoggined,
};
