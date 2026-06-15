package com.socialmedia.notification;

import com.socialmedia.enums.NotificationType;
import com.socialmedia.model.User;
import java.time.LocalDateTime;

public abstract class Notification {
    protected String notificationId;
    protected User recipient;
    protected User sender;
    protected NotificationType type;
    protected String message;
    protected LocalDateTime createdAt;
    protected boolean isRead;

    public Notification(String notificationId, User recipient, User sender, NotificationType type, String message) {
        this.notificationId = notificationId;
        this.recipient = recipient;
        this.sender = sender;
        this.type = type;
        this.message = message;
        this.createdAt = LocalDateTime.now();
        this.isRead = false;
    }

    public String getNotificationId() {
        return notificationId;
    }

    public User getRecipient() {
        return recipient;
    }

    public User getSender() {
        return sender;
    }

    public NotificationType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public boolean isRead() {
        return isRead;
    }

    public void markAsRead() {
        this.isRead = true;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId='" + notificationId + '\'' +
                ", recipient=" + recipient.getUsername() +
                ", sender=" + sender.getUsername() +
                ", type=" + type +
                ", message='" + message + '\'' +
                ", isRead=" + isRead +
                '}';
    }
}

