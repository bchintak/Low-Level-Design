package com.bookmyshow.notification;

import com.bookmyshow.model.Ticket;
import com.bookmyshow.model.User;

public class SmsNotifier
        implements Notifier {

    @Override
    public void notify(
            User user,
            Ticket ticket) {

        System.out.println(
                "SMS sent for Ticket : "
                        + ticket.getTicketId()
        );
    }
}