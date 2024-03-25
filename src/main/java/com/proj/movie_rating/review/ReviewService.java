package com.proj.movie_rating.review;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Connection to the database's table: Review
 */
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    /**
     * Provide a list of all the reviews
     * @return list of reviews
     */
    public List<Review> getReviews(){
        return reviewRepository.findAll();
    }
}
