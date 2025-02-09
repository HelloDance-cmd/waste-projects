/*
    private Long id;

    private Long articleId;

    private Long userId;

    private String commentContent;

    private Date commentTime;

    private Long parentCommentId;
 */

export interface Comment {
    id: number, // Current comment-id
    articleId: number, // Belong to article-id
    userId: number, // Submitting the user of the comment id
    commentContent: string, // The comment content
    commentTime: Date, //  the request date of comment
    parentCommentId: number | null // the parent of the current comment
}