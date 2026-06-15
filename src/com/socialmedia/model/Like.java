package com.socialmedia.model;

import java.time.LocalDateTime;

public class Like {
    private String likeId;
    private User user;
    private Post post;
    private LocalDateTime createdAt;

    public Like(String likeId, User user, Post post) {
        this.likeId = likeId;
        this.user = user;
        this.post = post;
        this.createdAt = LocalDateTime.now();
    }

    public String getLikeId() {
        return likeId;
    }

    public User getUser() {
        return user;
    }

    public Post getPost() {
        return post;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Like like = (Like) obj;
        return likeId.equals(like.likeId);
    }

    @Override
    public int hashCode() {
        return likeId.hashCode();
    }

    @Override
    public String toString() {
        return "Like{" +
                "likeId='" + likeId + '\'' +
                ", user=" + user.getUsername() +
                ", createdAt=" + createdAt +
                '}';
    }
}
