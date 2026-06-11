package com.library.model;

import com.library.enums.ReservationStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class BookReservation {

    private final String reservationId;
    private final Member member;
    private final BookItem bookItem;
    private ReservationStatus status;
    private final LocalDateTime reservedAt;

    public BookReservation(Member member,
                           BookItem bookItem) {

        this.reservationId = UUID.randomUUID().toString();
        this.member = member;
        this.bookItem = bookItem;
        this.status = ReservationStatus.WAITING;
        this.reservedAt = LocalDateTime.now();
    }

    public Member getMember() {
        return member;
    }

    public BookItem getBookItem() {
        return bookItem;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public String getReservationId() {
        return reservationId;
    }
}