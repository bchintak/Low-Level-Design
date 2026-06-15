package com.socialmedia.facade;

import com.socialmedia.enums.PostVisibility;
import com.socialmedia.model.User;
import com.socialmedia.model.Post;
import com.socialmedia.model.Comment;
import com.socialmedia.notification.Notification;
import com.socialmedia.notification.NotificationFactory;
import com.socialmedia.observer.Observer;
import com.socialmedia.observer.NotificationObserver;
import com.socialmedia.observer.Subject;
import com.socialmedia.service.UserService;
import com.socialmedia.service.PostService;
import java.util.ArrayList;
import java.util.List;

public class SocialMediaFacade implements Subject {
    private UserService userService;
    private PostService postService;
    private List<Observer> observers;

    public SocialMediaFacade() {
        this.userService = new UserService();
        this.postService = new PostService();
        this.observers = new ArrayList<>();
    }

    // User Operations
    public void createUser(String userId, String username, String email) {
        if (userId == null || userId.isEmpty() || username == null || username.isEmpty() || email == null || email.isEmpty()) {
            throw new IllegalArgumentException("userId, username, and email cannot be null or empty");
        }
        User user = new User(userId, username, email);
        userService.createUser(user);
        observers.add(new NotificationObserver(user));
    }

    public User getUserById(String userId) {
        return userService.getUserById(userId);
    }

    public User getUserByUsername(String username) {
        return userService.getUserByUsername(username);
    }

    public void followUser(String followerId, String followingId) {
        User follower = userService.getUserById(followerId);
        User following = userService.getUserById(followingId);
        if (userService.followUser(follower, following)) {
            Notification notification = NotificationFactory.createFollowNotification(
                    "NOTIF_" + System.currentTimeMillis(), following, follower);
            notifyObservers(notification);
        }
    }

    public void unfollowUser(String followerId, String followingId) {
        User follower = userService.getUserById(followerId);
        User following = userService.getUserById(followingId);
        userService.unfollowUser(follower, following);
    }

    // Post Operations
    public Post createPost(String userId, String content, PostVisibility visibility) {
        User author = userService.getUserById(userId);
        if (author == null) {
            throw new IllegalArgumentException("User with ID " + userId + " not found");
        }
        return postService.createPost(author, content, visibility);
    }

    public Post getPostById(String postId) {
        return postService.getPostById(postId);
    }

    public void deletePost(String postId) {
        postService.deletePost(postId);
    }

    // Like Operations
    public void likePost(String userId, String postId) {
        User user = userService.getUserById(userId);
        Post post = postService.getPostById(postId);
        if (user != null && post != null) {
            postService.likePost(user, post);
            Notification notification = NotificationFactory.createLikeNotification(
                    "NOTIF_" + System.currentTimeMillis(), post.getAuthor(), user, post);
            notifyObservers(notification);
        }
    }

    public void unlikePost(String userId, String postId) {
        User user = userService.getUserById(userId);
        Post post = postService.getPostById(postId);
        if (user != null && post != null) {
            postService.unlikePost(user, post);
        }
    }

    // Comment Operations
    public void addComment(String userId, String postId, String content) {
        User author = userService.getUserById(userId);
        Post post = postService.getPostById(postId);
        if (author != null && post != null) {
            Comment comment = postService.addComment(author, post, content);
            Notification notification = NotificationFactory.createCommentNotification(
                    "NOTIF_" + System.currentTimeMillis(), post.getAuthor(), author, comment);
            notifyObservers(notification);
        }
    }

    public void removeComment(String postId, String commentId) {
        Post post = postService.getPostById(postId);
        if (post != null) {
            postService.removeComment(post, commentId);
        }
    }

    // Feed Operations
    public void viewPostFeed(String postId) {
        Post post = postService.getPostById(postId);
        if (post != null) {
            postService.printPostFeed(post);
        }
    }

    // Observer Pattern Implementation
    @Override
    public void attach(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Notification notification) {
        for (Observer observer : observers) {
            if (observer instanceof NotificationObserver) {
                NotificationObserver notifObserver = (NotificationObserver) observer;
                if (notifObserver.getUser().equals(notification.getRecipient())) {
                    observer.update(notification);
                }
            }
        }
    }
}

