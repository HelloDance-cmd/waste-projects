import {Comment} from "@/type/CommentType";

/*
    private String title;
    private Long author;
    private String content;
    private List<Comments> comments;
 */

export type ArticleInfo = {
    title: string,
    content: string,
    author: number,
    comments: Comment[]
}

/*
    private String title;
    private String content;
    private Long author;
    private Date publishDate;
    private String category;
 */
export type ArticlePublish = {
    title: string,
    content: string,
    author: number,
    publishDate: Date,
    category: string
}