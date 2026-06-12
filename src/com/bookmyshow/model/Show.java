package com.bookmyshow.model;

import java.time.LocalDateTime;
import java.util.List;

public class Show {

    private String showId;

    private Movie movie;

    private Screen screen;

    private LocalDateTime startTime;

    private List<ShowSeat> seats;

    public Show(String showId, Movie movie, Screen screen, LocalDateTime startTime, List<ShowSeat> seats) {
        this.showId = showId;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
        this.seats = seats;
    }

    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public List<ShowSeat> getSeats() {
        return seats;
    }

    public void setSeats(List<ShowSeat> seats) {
        this.seats = seats;
    }
}
