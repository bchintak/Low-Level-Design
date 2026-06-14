package com.wms.notification;

public interface NotificationService {

    void send(String recipient, String message);
}