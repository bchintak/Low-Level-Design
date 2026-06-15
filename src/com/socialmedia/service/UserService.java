package com.socialmedia.service;

import com.socialmedia.model.User;
import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, User> users;

    public UserService() {
        this.users = new HashMap<>();
    }

    public void createUser(User user) {
        if (user == null || user.getUserId() == null || user.getUserId().isEmpty()) {
            throw new IllegalArgumentException("User and user ID cannot be null or empty");
        }
        users.put(user.getUserId(), user);
        System.out.println("User " + user.getUsername() + " created successfully");
    }

    public User getUserById(String userId) {
        return users.get(userId);
    }

    public User getUserByUsername(String username) {
        return users.values().stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    public boolean followUser(User follower, User following) {
        if (follower != null && following != null && !follower.equals(following)) {
            follower.addFollowing(following);
            following.addFollower(follower);
            System.out.println(follower.getUsername() + " started following " + following.getUsername());
            return true;
        }
        return false;
    }

    public boolean unfollowUser(User follower, User following) {
        if (follower != null && following != null) {
            follower.removeFollowing(following);
            following.removeFollower(follower);
            System.out.println(follower.getUsername() + " unfollowed " + following.getUsername());
            return true;
        }
        return false;
    }

    public Map<String, User> getAllUsers() {
        return new HashMap<>(users);
    }

    public void deleteUser(String userId) {
        users.remove(userId);
        System.out.println("User with ID " + userId + " deleted successfully");
    }
}

