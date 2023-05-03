package com.wolfalone.moviesapi.repositoty;

import com.wolfalone.moviesapi.entity.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo  extends MongoRepository<Review, ObjectId> {
}
