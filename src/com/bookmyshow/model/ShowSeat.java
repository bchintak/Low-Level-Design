package com.bookmyshow.model;

import com.bookmyshow.enums.SeatStatus;

public class ShowSeat {
    private String id;
    private Seat seat;
    private SeatStatus status;
    private double price;

    public ShowSeat(String id, Seat seat, SeatStatus status, double price) {
        this.id = id;
        this.seat = seat;
        this.status = status;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
