package com.bookmyshow.service;

import com.bookmyshow.enums.SeatStatus;
import com.bookmyshow.model.ShowSeat;

public class SeatLockService {
    public synchronized boolean lockSeat(ShowSeat showSeat) {
        if(showSeat.getStatus() != SeatStatus.AVAILABLE ){
            return false;
        }
        showSeat.setStatus(SeatStatus.LOCKED);
        return true;
    }
}
