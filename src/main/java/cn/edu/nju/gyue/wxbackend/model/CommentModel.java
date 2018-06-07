package cn.edu.nju.gyue.wxbackend.model;

import cn.edu.nju.gyue.wxbackend.parm.CommentType;

public class CommentModel {

    private Long commentId;

    private boolean isReply;

    private String username;

    private String comment;

    private CommentType commentType;

    private Long relatedId;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public boolean getIsReply() {
        return isReply;
    }

    public void setIsReply(boolean reply) {
        isReply = reply;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public CommentType getCommentType() {
        return commentType;
    }

    public void setCommentType(CommentType commentType) {
        this.commentType = commentType;
    }

    public Long getRelatedId() {
        return relatedId;
    }

    public void setRelatedId(Long relatedId) {
        this.relatedId = relatedId;
    }
}
