package com.bookmyshow.model;

import java.util.List;

public class Screen {

    private String screenId;

    private String name;

    private Theater theater;

    private List<Seat> seats;

    public Screen(String screenId, String name, Theater theater, List<Seat> seats) {
        this.screenId = screenId;
        this.name = name;
        this.theater = theater;
        this.seats = seats;
    }

    public String getScreenId() {
        return screenId;
    }

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
