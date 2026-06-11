package com.library.repository;

import com.library.model.BookReservation;

import java.util.*;

public class ReservationRepository {

    private final Map<String,
            Queue<BookReservation>>
            reservationMap =
            new HashMap<>();

    public void save(BookReservation reservation) {

        String barcode =
                reservation.getBookItem()
                        .getBarcode();

        reservationMap
                .computeIfAbsent(
                        barcode,
                        k -> new LinkedList<>())
                .offer(reservation);
    }

    public Optional<BookReservation>
    getNextReservation(String barcode) {

        Queue<BookReservation> queue =
                reservationMap.get(barcode);

        if(queue == null || queue.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(queue.peek());
    }

    public void removeReservation(
            BookReservation reservation) {

        String barcode =
                reservation.getBookItem()
                        .getBarcode();

        Queue<BookReservation> queue =
                reservationMap.get(barcode);

        if(queue != null) {
            queue.remove(reservation);
        }
    }
}