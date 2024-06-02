package com.proj.movie_rating.service;

import com.proj.movie_rating.model.Review;
import com.proj.movie_rating.repository.ReviewRepository;
import com.proj.movie_rating.service_contract.ReviewServiceContract;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing operations related to the 'Review' entity in the database.
 */
@Service
public class ReviewService implements ReviewServiceContract {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    /**
     * Retrieves a list of all reviews.
     *
     * @return A list of all reviews.
     */
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    /**
     * Retrieves a list of all reviews
     *
     * @param id The ID of the movie
     * @return A list of all reviews of a certain movie
     */
    @Override
    public List<Review> getAllReviewsByMovie(int id) {
        return this.reviewRepository.findAllByMovie(id);
    }

    /**
     * Retrieves a review by its ID.
     *
     * @param id The ID of the review to retrieve.
     * @return The review with the specified ID, or null if not found.
     */
    public Review getReview(int id) {
        return reviewRepository.findById(id).orElse(null);
    }

    /**
     * Deletes a review by its ID, if it exists.
     *
     * @param id The ID of the review to delete.
     * @return true if the review was successfully deleted, false otherwise.
     */
    public boolean deleteAReview(Integer id) {
        if (reviewRepository.existsById(id)) {
            reviewRepository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Inserts a new review.
     *
     * @param review The review object to insert.
     */
    public void postReview(Review review) {
        reviewRepository.save(review);
    }

    /**
     * Modifies the review with the specified ID by updating its review text and rating, if it exists.
     *
     * @param id     The ID of the review to update.
     * @param review The updated review object.
     * @return true if the review was successfully updated, false otherwise.
     */
    public boolean putReview(Integer id, Review review) {
        if (reviewRepository.existsById(id)) {
            Review current = reviewRepository.findById(id).get();
            current.setReview(review.getReview());
            current.setRating(review.getRating());
            reviewRepository.save(current);
            return true;
        }
        return false;
    }
}
