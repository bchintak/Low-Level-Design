package com.bookmyshow.model;

import java.time.LocalDateTime;
import java.util.List;

public class Ticket {

    private String ticketId;

    private String bookingId;

    private String movieName;

    private String theaterName;

    private String screenName;

    private LocalDateTime showTime;

    private List<String> seatNumbers;

    public Ticket(
            String ticketId,
            String bookingId,
            String movieName,
            String theaterName,
            String screenName,
            LocalDateTime showTime,
            List<String> seatNumbers) {

        this.ticketId = ticketId;
        this.bookingId = bookingId;
        this.movieName = movieName;
        this.theaterName = theaterName;
        this.screenName = screenName;
        this.showTime = showTime;
        this.seatNumbers = seatNumbers;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public String getScreenName() {
        return screenName;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public List<String> getSeatNumbers() {
        return seatNumbers;
    }
}