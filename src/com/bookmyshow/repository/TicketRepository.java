package com.bookmyshow.repository;

import com.bookmyshow.model.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {

    private final Map<String, Ticket> tickets =
            new HashMap<>();

    public void save(Ticket ticket) {

        tickets.put(
                ticket.getTicketId(),
                ticket
        );
    }

    public Ticket findById(String ticketId) {

        return tickets.get(ticketId);
    }
}
