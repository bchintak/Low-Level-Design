package com.bookmyshow.state;

import com.bookmyshow.enums.BookingStatus;
import com.bookmyshow.model.Booking;

public class CreatedState
        implements BookingState {

    @Override
    public void next(Booking booking) {
        booking.setStatus(
                BookingStatus.CONFIRMED);
    }

}
