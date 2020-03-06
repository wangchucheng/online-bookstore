package com.wangchucheng.onlinebookstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Comment {
    @Id
    @GeneratedValue
    private Long commentId;

    private Long userId;

    private String isbn;

    private String content;

    private int stars;

    private Timestamp time;

    public Comment() {
    }

    public Comment(Long userId, String isbn, String content, int stars, Timestamp time) {
        this.userId = userId;
        this.isbn = isbn;
        this.content = content;
        this.stars = stars;
        this.time = time;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
