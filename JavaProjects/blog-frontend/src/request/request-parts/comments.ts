import { AxiosRequestConfig } from "axios";
import { Response, ins } from "..";
import { Comment } from "../../types/Comment";

/**
 * 通过文章id获取文章的评论内容列表
 * @param articleId 文章id
 * @param config
 * @returns
 */
export const getCommentListById = (
  articleId: number,
  config?: AxiosRequestConfig
): Response<Comment[]> => {
  return ins.get(`/api/comments/article/${articleId}`, config);
};

/**
 * 提交一个用户评论
 * @param comment
 * @returns
 */
export const commitUserComment = (comment: string) => {
  return ins.post("/api/api/comments", {
    comment,
  });
};
