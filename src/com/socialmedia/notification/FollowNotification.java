package com.socialmedia.notification;

import com.socialmedia.enums.NotificationType;
import com.socialmedia.model.User;

public class FollowNotification extends Notification {
    public FollowNotification(String notificationId, User recipient, User sender) {
        super(notificationId, recipient, sender, NotificationType.FOLLOW, 
              sender.getUsername() + " started following you");
    }

    @Override
    public String toString() {
        return "FollowNotification{" +
                "notificationId='" + notificationId + '\'' +
                ", recipient=" + recipient.getUsername() +
                ", sender=" + sender.getUsername() +
                ", message='" + message + '\'' +
                '}';
    }
}

