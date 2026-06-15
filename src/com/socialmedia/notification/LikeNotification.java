package com.socialmedia.notification;

import com.socialmedia.enums.NotificationType;
import com.socialmedia.model.User;
import com.socialmedia.model.Post;

public class LikeNotification extends Notification {
    private Post post;

    public LikeNotification(String notificationId, User recipient, User sender, Post post) {
        super(notificationId, recipient, sender, NotificationType.LIKE, 
              sender.getUsername() + " liked your post");
        this.post = post;
    }

    public Post getPost() {
        return post;
    }

    @Override
    public String toString() {
        return "LikeNotification{" +
                "notificationId='" + notificationId + '\'' +
                ", recipient=" + recipient.getUsername() +
                ", sender=" + sender.getUsername() +
                ", post='" + post.getPostId() + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}

