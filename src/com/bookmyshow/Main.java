package com.bookmyshow;

import com.bookmyshow.enums.SeatStatus;
import com.bookmyshow.enums.SeatType;
import com.bookmyshow.factory.BookingFactory;
import com.bookmyshow.model.*;
import com.bookmyshow.notification.EmailNotifier;
import com.bookmyshow.notification.SmsNotifier;
import com.bookmyshow.notification.WhatsAppNotifier;
import com.bookmyshow.repository.BookingRepository;
import com.bookmyshow.repository.TicketRepository;
import com.bookmyshow.service.*;

import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /*
         * ---------------------------------
         * Repositories
         * ---------------------------------
         */

        TicketRepository ticketRepository =
                new TicketRepository();

        BookingRepository bookingRepository =
                new BookingRepository();

        /*
         * ---------------------------------
         * Services
         * ---------------------------------
         */

        TicketService ticketService =
                new TicketService(
                        ticketRepository);

        NotificationService notificationService =
                new NotificationService(
                        List.of(
                                new EmailNotifier(),
                                new SmsNotifier(),
                                new WhatsAppNotifier()
                        )
                );

        SeatLockService seatLockService =
                new SeatLockService();

        PaymentService paymentService =
                new PaymentService();

        BookingFactory bookingFactory =
                new BookingFactory();

        BookingService bookingService =
                new BookingService(
                        bookingRepository,
                        bookingFactory,
                        seatLockService,
                        paymentService,
                        ticketService,
                        notificationService
                );

        /*
         * ---------------------------------
         * User
         * ---------------------------------
         */

        User bhanu =
                new User(
                        "U1",
                        "Bhanu",
                        "bhanu@gmail.com"
                );

        /*
         * ---------------------------------
         * Movie
         * ---------------------------------
         */

        Movie pushpa =
                new Movie(
                        "M1",
                        "Pushpa 3",
                        "Telugu",
                        180
                );

        /*
         * ---------------------------------
         * Theater
         * ---------------------------------
         */

        Theater pvr =
                new Theater(
                        "T1",
                        "PVR Hyderabad",
                        "Hyderabad"
                );

        /*
         * ---------------------------------
         * Seats
         * ---------------------------------
         */

        Seat seatA1 =
                new Seat(
                        "S1",
                        "A",
                        "1",
                        SeatType.REGULAR
                );

        Seat seatA2 =
                new Seat(
                        "S2",
                        "A",
                        "2",
                        SeatType.REGULAR
                );

        Seat seatA3 =
                new Seat(
                        "S3",
                        "A",
                        "3",
                        SeatType.REGULAR
                );

        /*
         * ---------------------------------
         * Screen
         * ---------------------------------
         */

        Screen screen1 =
                new Screen(
                        "SC1",
                        "Screen-1",
                        pvr,
                        List.of(
                                seatA1,
                                seatA2,
                                seatA3
                        )
                );

        /*
         * ---------------------------------
         * Show Seats
         * ---------------------------------
         */

        ShowSeat showSeat1 =
                new ShowSeat(
                        "SS1",
                        seatA1,
                        SeatStatus.AVAILABLE,
                        200
                );

        ShowSeat showSeat2 =
                new ShowSeat(
                        "SS2",
                        seatA2,
                        SeatStatus.AVAILABLE,
                        200
                );

        ShowSeat showSeat3 =
                new ShowSeat(
                        "SS3",
                        seatA3,
                        SeatStatus.AVAILABLE,
                        200
                );

        /*
         * ---------------------------------
         * Show
         * ---------------------------------
         */

        Show show =
                new Show(
                        "SHOW1",
                        pushpa,
                        screen1,
                        LocalDateTime.now().plusHours(2),
                        List.of(
                                showSeat1,
                                showSeat2,
                                showSeat3
                        )
                );

        /*
         * ---------------------------------
         * Bhanu selects seats
         * ---------------------------------
         */

        List<ShowSeat> selectedSeats =
                List.of(
                        showSeat1,
                        showSeat2
                );

        /*
         * ---------------------------------
         * Book Ticket
         * ---------------------------------
         */

        Booking booking =
                bookingService.bookTicket(
                        bhanu,
                        show,
                        selectedSeats
                );

        /*
         * ---------------------------------
         * Output
         * ---------------------------------
         */

        System.out.println();
        System.out.println("===== BOOKING SUCCESS =====");

        System.out.println(
                "Booking Id : "
                        + booking.getBookingId());

        System.out.println(
                "Movie : "
                        + booking.getShow()
                        .getMovie()
                        .getName());

        System.out.println(
                "Amount : "
                        + booking.getTotalAmount());

        System.out.println(
                "Status : "
                        + booking.getStatus());

        System.out.println("===========================");
    }
}