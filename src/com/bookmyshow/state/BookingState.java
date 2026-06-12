package com.bookmyshow.state;

import com.bookmyshow.model.Booking;

public interface BookingState {
    void next(Booking booking);
}
