package com.bookmyshow.service;

import com.bookmyshow.model.Show;
import com.bookmyshow.repository.ShowRepository;

import java.util.List;

public class SearchService {

    private ShowRepository showRepository;

    public List<Show> searchByMovie(
            String movieId) {

        return showRepository.findByMovie(movieId);
    }
}