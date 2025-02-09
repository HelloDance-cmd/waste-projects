import { AxiosRequestConfig } from "axios";
import { Response, ins } from "..";
import { Article } from "../../types/Article";

/**
 * 获取所有的文章
 * @param config
 * @returns
 */
export const requestArticles = (
  config?: AxiosRequestConfig
): Response<Article[]> => {
  return ins.get("/api/articles", config);
};
/**
 * 通过文章id获取文章信息
 * @param id 文章id
 * @param config
 * @returns
 */

export const requestArticleById = (
  id: number,
  config?: AxiosRequestConfig
): Response<Article> => {
  return ins.get("/api/articles/", {
    params: {
      articleId: id,
    },
    ...config,
  });
};

/**
 * 发布一篇文章
 * @param article 文章
 * @param config
 * @returns
 */
export const publishArticle = (
  article: Article,
  config?: AxiosRequestConfig
) => {
  return ins.post(
    "/api/articles",
    {
      article,
    },
    config
  );
};
