package com.design_patterns.structural.bridge;
public abstract class Notification {

    protected NotificationProvider provider;

    public Notification(
            NotificationProvider provider) {

        this.provider = provider;
    }

    public abstract void send(
            String message);
}
