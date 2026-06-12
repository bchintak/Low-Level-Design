package com.bookmyshow.service;

import com.bookmyshow.model.Booking;
import com.bookmyshow.model.Ticket;
import com.bookmyshow.repository.TicketRepository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class TicketService {

    private final TicketRepository ticketRepository;

    public TicketService(
            TicketRepository ticketRepository) {

        this.ticketRepository = ticketRepository;
    }

    public Ticket generateTicket(
            Booking booking) {

        if (booking == null) {
            throw new RuntimeException(
                    "Booking cannot be null"
            );
        }

        if (booking.getShowSeats() == null) {
            throw new RuntimeException(
                    "Booking seats are null"
            );
        }

        List<String> seatNumbers =
                booking.getShowSeats()
                        .stream()
                        .map(showSeat ->
                                showSeat.getSeat().getRow()
                                        + "-"
                                        + showSeat.getSeat().getSeatNumber())
                        .collect(Collectors.toList());

        Ticket ticket =
                new Ticket(
                        UUID.randomUUID().toString(),
                        booking.getBookingId(),
                        booking.getShow()
                                .getMovie()
                                .getName(),
                        booking.getShow()
                                .getScreen()
                                .getTheater()
                                .getName(),
                        booking.getShow()
                                .getScreen()
                                .getName(),
                        booking.getShow()
                                .getStartTime(),
                        seatNumbers
                );

        ticketRepository.save(ticket);

        return ticket;
    }
}