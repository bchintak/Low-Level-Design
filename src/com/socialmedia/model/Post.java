package com.socialmedia.model;

import com.socialmedia.enums.PostVisibility;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Post {
    private String postId;
    private User author;
    private String content;
    private PostVisibility visibility;
    private LocalDateTime createdAt;
    private List<Like> likes;
    private List<Comment> comments;

    public Post(String postId, User author, String content, PostVisibility visibility) {
        this.postId = postId;
        this.author = author;
        this.content = content;
        this.visibility = visibility;
        this.createdAt = LocalDateTime.now();
        this.likes = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public String getPostId() {
        return postId;
    }

    public User getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public PostVisibility getVisibility() {
        return visibility;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void addLike(Like like) {
        if (!likes.contains(like)) {
            likes.add(like);
        }
    }

    public void removeLike(Like like) {
        likes.remove(like);
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public int getLikeCount() {
        return likes.size();
    }

    public int getCommentCount() {
        return comments.size();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Post post = (Post) obj;
        return postId.equals(post.postId);
    }

    @Override
    public int hashCode() {
        return postId.hashCode();
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId='" + postId + '\'' +
                ", author=" + author.getUsername() +
                ", content='" + content + '\'' +
                ", visibility=" + visibility +
                ", likes=" + likes.size() +
                ", comments=" + comments.size() +
                '}';
    }
}
