package com.proj.movie_rating.service;

import com.proj.movie_rating.model.Review;
import com.proj.movie_rating.model.Review;
import com.proj.movie_rating.repository.ReviewRepository;
import com.proj.movie_rating.repository.ReviewRepository;
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
    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }

    public Review getReview(int id){
        return reviewRepository.findById(id).orElse(null);
    }

    /**
     * Delete the review by id, if it exists
     * @param id
     * @return true if review with id is available, else false
     */
    public boolean deleteAReview(Integer id){
        if(reviewRepository.existsById(id)) {
            reviewRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Insert a new review
     * @param review
     */
    public void postReview(Review review) {
        reviewRepository.save(review);
    }

    /**
     * Modify the review with a certain id, by releaseYear and rating, if it exists
     * @param id
     * @param review
     * @return
     */
    public boolean putReview(Integer id, Review review) {
        if(reviewRepository.existsById(id)) {
            Review current =  reviewRepository.findById(id).get();
            current.setReview(review.getReview());
            current.setRating(review.getRating());
            reviewRepository.save(current);
            return true;
        }
        return false;
    }
}
