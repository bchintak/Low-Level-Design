package com.socialmedia.observer;

import com.socialmedia.notification.Notification;

public interface Observer {
    void update(Notification notification);
}