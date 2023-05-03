package com.wolfalone.moviesapi.service;

import com.wolfalone.moviesapi.entity.Review;
import org.springframework.stereotype.Service;

@Service
public interface ReviewService {
    Review createReview(String reviewBody, String imdbId);
}
