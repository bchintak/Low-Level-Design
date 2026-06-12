package com.bookmyshow.notification;

import com.bookmyshow.model.Ticket;
import com.bookmyshow.model.User;

public interface Notifier {

    void notify(
            User user,
            Ticket ticket);
}