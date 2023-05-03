package com.wolfalone.moviesapi.service;


import com.wolfalone.moviesapi.entity.Movie;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MovieService {
    List<Movie> allMovie();

    Optional<Movie> getMovie(ObjectId id);

    Optional<Movie> getByImdbId(String id);
}
