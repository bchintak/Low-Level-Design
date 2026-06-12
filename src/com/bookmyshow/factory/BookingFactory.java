package com.bookmyshow.factory;

import com.bookmyshow.enums.BookingStatus;
import com.bookmyshow.model.Booking;
import com.bookmyshow.model.Show;
import com.bookmyshow.model.ShowSeat;
import com.bookmyshow.model.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class BookingFactory {

    public Booking createBooking(
            User user,
            Show show,
            List<ShowSeat> seats,
            double amount) {

        return new Booking(
                UUID.randomUUID().toString(),
                user,
                show,
                seats,
                amount,
                BookingStatus.CONFIRMED,
                LocalDateTime.now()
        );
    }
}