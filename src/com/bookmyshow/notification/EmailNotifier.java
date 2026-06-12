package com.bookmyshow.notification;

import com.bookmyshow.model.Ticket;
import com.bookmyshow.model.User;

public class EmailNotifier
        implements Notifier {

    @Override
    public void notify(
            User user,
            Ticket ticket) {

        System.out.println(
                "Email sent to "
                        + user.getEmail()
                        + " TicketId : "
                        + ticket.getTicketId()
        );
    }
}