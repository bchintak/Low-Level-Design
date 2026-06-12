package com.bookmyshow.service;

import com.bookmyshow.model.Ticket;
import com.bookmyshow.model.User;
import com.bookmyshow.notification.Notifier;

import java.util.List;

public class NotificationService {

    private final List<Notifier> notifiers;

    public NotificationService(
            List<Notifier> notifiers) {

        this.notifiers = notifiers;
    }

    public void sendConfirmation(
            User user,
            Ticket ticket) {

        for(Notifier notifier : notifiers) {

            notifier.notify(
                    user,
                    ticket
            );
        }
    }
}