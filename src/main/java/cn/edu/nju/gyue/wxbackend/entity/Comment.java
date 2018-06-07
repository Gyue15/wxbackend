package cn.edu.nju.gyue.wxbackend.entity;

import cn.edu.nju.gyue.wxbackend.parm.CommentType;

import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    private boolean isReply;

    private String username;

    private String comment;

    @Enumerated(EnumType.STRING)
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

    public void setReply(boolean reply) {
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

    public Long getRelatedId() {
        return relatedId;
    }

    public void setRelatedId(Long relatedId) {
        this.relatedId = relatedId;
    }

    public CommentType getCommentType() {
        return commentType;
    }

    public void setCommentType(CommentType commentType) {
        this.commentType = commentType;
    }
}
