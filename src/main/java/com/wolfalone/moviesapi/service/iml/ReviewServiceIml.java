package com.wolfalone.moviesapi.service.iml;

import com.wolfalone.moviesapi.entity.Movie;
import com.wolfalone.moviesapi.entity.Review;
import com.wolfalone.moviesapi.repositoty.ReviewRepo;
import com.wolfalone.moviesapi.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceIml implements ReviewService {

    @Autowired
    private ReviewRepo reviewRepo;

    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public Review createReview(String reviewBody, String imdbId) {
        Review review = Review.builder()
                .body(reviewBody)
                .build();
        reviewRepo.insert(review);
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();
        return review;
    }
}
