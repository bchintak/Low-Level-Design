package com.socialmedia.model;

import java.time.LocalDateTime;

public class Comment {
    private String commentId;
    private User author;
    private Post post;
    private String content;
    private LocalDateTime createdAt;

    public Comment(String commentId, User author, Post post, String content) {
        this.commentId = commentId;
        this.author = author;
        this.post = post;
        this.content = content;
        this.createdAt = LocalDateTime.now();
    }

    public String getCommentId() {
        return commentId;
    }

    public User getAuthor() {
        return author;
    }

    public Post getPost() {
        return post;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Comment comment = (Comment) obj;
        return commentId.equals(comment.commentId);
    }

    @Override
    public int hashCode() {
        return commentId.hashCode();
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId='" + commentId + '\'' +
                ", author=" + author.getUsername() +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
