package com.socialmedia.notification;

import com.socialmedia.enums.NotificationType;
import com.socialmedia.model.User;
import com.socialmedia.model.Post;
import com.socialmedia.model.Comment;

public class NotificationFactory {

    public static Notification createLikeNotification(String notificationId, User recipient, User sender, Post post) {
        return new LikeNotification(notificationId, recipient, sender, post);
    }

    public static Notification createCommentNotification(String notificationId, User recipient, User sender, Comment comment) {
        return new CommentNotification(notificationId, recipient, sender, comment);
    }

    public static Notification createFollowNotification(String notificationId, User recipient, User sender) {
        return new FollowNotification(notificationId, recipient, sender);
    }
}

