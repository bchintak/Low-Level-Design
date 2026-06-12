package com.bookmyshow.model;

import com.bookmyshow.enums.BookingStatus;

import java.time.LocalDateTime;
import java.util.List;

public class Booking {

    private String bookingId;

    private User user;

    private Show show;

    private List<ShowSeat> showSeats;

    private double totalAmount;

    private BookingStatus status;

    private LocalDateTime bookedAt;

    public Booking(
            String bookingId,
            User user,
            Show show,
            List<ShowSeat> showSeats,
            double totalAmount,
            BookingStatus status,
            LocalDateTime bookedAt) {

        this.bookingId = bookingId;
        this.user = user;
        this.show = show;
        this.showSeats = showSeats;
        this.totalAmount = totalAmount;
        this.status = status;
        this.bookedAt = bookedAt;
    }

    public String getBookingId() {
        return bookingId;
    }

    public User getUser() {
        return user;
    }

    public Show getShow() {
        return show;
    }

    public List<ShowSeat> getShowSeats() {
        return showSeats;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public LocalDateTime getBookedAt() {
        return bookedAt;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}