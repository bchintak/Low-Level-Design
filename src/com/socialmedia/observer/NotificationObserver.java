package com.socialmedia.observer;

import com.socialmedia.model.User;
import com.socialmedia.notification.Notification;

public class NotificationObserver implements Observer {
    private User user;

    public NotificationObserver(User user) {
        this.user = user;
    }

    @Override
    public void update(Notification notification) {
        System.out.println("User " + user.getUsername() + " received notification: " + notification);
    }

    public User getUser() {
        return user;
    }
}