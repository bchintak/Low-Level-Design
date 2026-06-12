package com.bookmyshow.service;

import com.bookmyshow.enums.SeatStatus;
import com.bookmyshow.factory.BookingFactory;
import com.bookmyshow.model.Booking;
import com.bookmyshow.model.Show;
import com.bookmyshow.model.ShowSeat;
import com.bookmyshow.model.Ticket;
import com.bookmyshow.model.User;
import com.bookmyshow.repository.BookingRepository;

import java.util.List;

public class BookingService {

    private final BookingRepository bookingRepository;

    private final BookingFactory bookingFactory;

    private final SeatLockService seatLockService;

    private final PaymentService paymentService;

    private final TicketService ticketService;

    private final NotificationService notificationService;

    public BookingService(
            BookingRepository bookingRepository,
            BookingFactory bookingFactory,
            SeatLockService seatLockService,
            PaymentService paymentService,
            TicketService ticketService,
            NotificationService notificationService) {

        this.bookingRepository = bookingRepository;
        this.bookingFactory = bookingFactory;
        this.seatLockService = seatLockService;
        this.paymentService = paymentService;
        this.ticketService = ticketService;
        this.notificationService = notificationService;
    }

    public Booking bookTicket(
            User user,
            Show show,
            List<ShowSeat> selectedSeats) {

        try {

            /*
             * Step 1
             * Lock all seats
             */

            lockSeats(selectedSeats);

            /*
             * Step 2
             * Calculate total amount
             */

            double totalAmount =
                    calculateAmount(selectedSeats);

            /*
             * Step 3
             * Payment
             */

            boolean paymentSuccess =
                    paymentService.pay(totalAmount);

            if (!paymentSuccess) {

                releaseSeats(selectedSeats);

                throw new RuntimeException(
                        "Payment Failed"
                );
            }

            /*
             * Step 4
             * Mark seats BOOKED
             */

            markSeatsBooked(selectedSeats);

            /*
             * Step 5
             * Create Booking
             */

            Booking booking =
                    bookingFactory.createBooking(
                            user,
                            show,
                            selectedSeats,
                            totalAmount
                    );

            /*
             * Step 6
             * Save Booking
             */

            bookingRepository.save(booking);

            /*
             * Step 7
             * Generate Ticket
             */

            Ticket ticket =
                    ticketService.generateTicket(
                            booking
                    );

            /*
             * Step 8
             * Send Notifications
             */

            notificationService.sendConfirmation(
                    user,
                    ticket
            );

            return booking;

        } catch (Exception ex) {

            releaseSeats(selectedSeats);

            throw ex;
        }
    }

    private void lockSeats(
            List<ShowSeat> seats) {

        for (ShowSeat seat : seats) {

            boolean locked =
                    seatLockService.lockSeat(
                            seat
                    );

            if (!locked) {

                throw new RuntimeException(
                        "Seat already booked : "
                                + seat.getSeat()
                                .getSeatNumber()
                );
            }
        }
    }

    private double calculateAmount(
            List<ShowSeat> seats) {

        return seats.stream()
                .mapToDouble(
                        ShowSeat::getPrice
                )
                .sum();
    }

    private void markSeatsBooked(
            List<ShowSeat> seats) {

        for (ShowSeat seat : seats) {

            seat.setStatus(
                    SeatStatus.BOOKED
            );
        }
    }

    private void releaseSeats(
            List<ShowSeat> seats) {

        for (ShowSeat seat : seats) {

            if (seat.getStatus()
                    == SeatStatus.LOCKED) {

                seat.setStatus(
                        SeatStatus.AVAILABLE
                );
            }
        }
    }
}