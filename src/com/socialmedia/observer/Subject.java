package com.socialmedia.observer;

import com.socialmedia.notification.Notification;

public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers(Notification notification);
}

