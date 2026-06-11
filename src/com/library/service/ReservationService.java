package com.library.service;

import com.library.enums.BookStatus;
import com.library.enums.ReservationStatus;
import com.library.model.*;
import com.library.repository.ReservationRepository;

import java.util.Optional;

public class ReservationService {

    private final ReservationRepository repository;

    public ReservationService(
            ReservationRepository repository) {

        this.repository = repository;
    }

    public BookReservation reserveBook(
            Member member,
            BookItem bookItem) {

        if(bookItem.getStatus()
                == BookStatus.AVAILABLE) {

            throw new RuntimeException(
                    "Book available. Borrow directly.");
        }

        BookReservation reservation =
                new BookReservation(
                        member,
                        bookItem);

        repository.save(reservation);

        return reservation;
    }

    public void cancelReservation(
            BookReservation reservation) {

        reservation.setStatus(
                ReservationStatus.CANCELLED);

        repository.removeReservation(
                reservation);
    }

    public Optional<BookReservation>
    getNextReservation(BookItem bookItem) {

        return repository.getNextReservation(
                bookItem.getBarcode());
    }

    public void completeReservation(
            BookReservation reservation) {

        reservation.setStatus(
                ReservationStatus.COMPLETED);

        repository.removeReservation(
                reservation);
    }
}