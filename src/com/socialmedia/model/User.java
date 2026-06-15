package com.socialmedia.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String username;
    private String email;
    private List<User> followers;
    private List<User> following;
    private List<Post> posts;

    public User(String userId, String username, String email) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.followers = new ArrayList<>();
        this.following = new ArrayList<>();
        this.posts = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public List<User> getFollowing() {
        return following;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void addFollower(User user) {
        if (!followers.contains(user)) {
            followers.add(user);
        }
    }

    public void removeFollower(User user) {
        followers.remove(user);
    }

    public void addFollowing(User user) {
        if (!following.contains(user)) {
            following.add(user);
        }
    }

    public void removeFollowing(User user) {
        following.remove(user);
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return userId.equals(user.userId);
    }

    @Override
    public int hashCode() {
        return userId.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
