package com.wolfalone.moviesapi.service.iml;


import com.wolfalone.moviesapi.entity.Movie;
import com.wolfalone.moviesapi.repositoty.MovieRepo;
import com.wolfalone.moviesapi.service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceIml implements MovieService {

    @Autowired
    private MovieRepo movieRepo;
    @Override
    public List<Movie> allMovie() {
        return movieRepo.findAll();
    }



    @Override
    public Optional<Movie> getMovie(ObjectId id) {
        return movieRepo.findById(id);
    }

    @Override
    public Optional<Movie> getByImdbId(String id) {
        return movieRepo.findMovieByImdbId(id);
    }
}


