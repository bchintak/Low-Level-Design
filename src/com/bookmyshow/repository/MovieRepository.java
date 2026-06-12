package com.bookmyshow.repository;

import com.bookmyshow.model.Movie;

import java.util.HashMap;
import java.util.Map;

public class MovieRepository {

    private Map<String, Movie> movies =
            new HashMap<>();

    public void save(Movie movie) {
        movies.put(movie.getMovieId(), movie);
    }

    public Movie findById(String id) {
        return movies.get(id);
    }
}
