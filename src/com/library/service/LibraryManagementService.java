package com.library.service;

import com.library.model.*;

import java.util.Optional;

public class LibraryManagementService {

    private final LendingService lendingService;
    private final ReservationService reservationService;

    public LibraryManagementService(
            LendingService lendingService,
            ReservationService reservationService) {

        this.lendingService = lendingService;
        this.reservationService = reservationService;
    }

    public void returnBook(BookItem bookItem) {

        lendingService.returnBook(bookItem);

        Optional<BookReservation>
                reservationOptional =
                reservationService
                        .getNextReservation(
                                bookItem);

        if(reservationOptional.isPresent()) {

            BookReservation reservation =
                    reservationOptional.get();

            System.out.println(
                    "Notification sent to : "
                            + reservation
                            .getMember()
                            .getName());

            reservationService
                    .completeReservation(
                            reservation);
        }
    }
}