package com.bookmyshow.model;

public class Seat {
    private String seatId;
    private String row;
    private String seatNumber;
    private Enum seatType;

    public Seat(String seatId, String row, String seatNumber, Enum seatType) {
        this.seatId = seatId;
        this.row = row;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Enum getSeatType() {
        return seatType;
    }

    public void setSeatType(Enum seatType) {
        this.seatType = seatType;
    }
}
