package com.socialmedia.notification;

import com.socialmedia.enums.NotificationType;
import com.socialmedia.model.User;
import com.socialmedia.model.Comment;

public class CommentNotification extends Notification {
    private Comment comment;

    public CommentNotification(String notificationId, User recipient, User sender, Comment comment) {
        super(notificationId, recipient, sender, NotificationType.COMMENT, 
              sender.getUsername() + " commented on your post");
        this.comment = comment;
    }

    public Comment getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return "CommentNotification{" +
                "notificationId='" + notificationId + '\'' +
                ", recipient=" + recipient.getUsername() +
                ", sender=" + sender.getUsername() +
                ", comment='" + comment.getCommentId() + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}

