package com.wms.factory;

import com.wms.enums.NotificationType;
import com.wms.notification.EmailNotification;
import com.wms.notification.NotificationService;
import com.wms.notification.SMSNotification;

public class NotificationFactory {

    private NotificationFactory() {
    }

    public static NotificationService create(NotificationType type) {

        return switch (type) {
            case EMAIL -> new EmailNotification();
            case SMS -> new SMSNotification();
        };
    }
}