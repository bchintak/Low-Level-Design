package com.bookmyshow.model;

public class Movie {
    private String movieId;
    private String name;
    private String language;
    private int duration;

    public Movie(String movieId, String name, String language, int duration) {
        this.movieId = movieId;
        this.name = name;
        this.language = language;
        this.duration = duration;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
