package com.bookmyshow.repository;

import com.bookmyshow.model.Show;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowRepository {

    private Map<String, Show> shows = new HashMap<>();

    public void save(Show show) {
        shows.put(show.getShowId(), show);
    }

    public Show findById(String showId) {
        return shows.get(showId);
    }

    public List<Show> findByMovie(String movieId) {

        return shows.values()
                .stream()
                .filter(show ->
                        show.getMovie()
                                .getMovieId()
                                .equals(movieId))
                .toList();
    }
}
