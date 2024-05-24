package com.proj.movie_rating.controller;

import com.proj.movie_rating.model.Review;
import com.proj.movie_rating.service.ReviewService;
import com.proj.movie_rating.service_contract.ReviewServiceContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/review")
public class ReviewController {

    private final ReviewServiceContract reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    /**
     * Retrieves all reviews.
     *
     * @return A list of all reviews.
     */
    @GetMapping("/show/all")
    public List<Review> showAllReviews() {
        return reviewService.getAllReviews();
    }

    /**
     * Retrieves a review by its ID.
     *
     * @param id The ID of the review to retrieve.
     * @return The review with the specified ID.
     */
    @GetMapping("/show/{id}")
    public Review showReview(@PathVariable("id") int id) {
        return reviewService.getReview(id);
    }

    /**
     * Deletes a review by its ID.
     *
     * @param id The ID of the review to delete.
     * @return true if the review was successfully deleted, false otherwise.
     */
    @DeleteMapping("/remove/{id}")
    public boolean removeReview(@PathVariable("id") Integer id) {
        return reviewService.deleteAReview(id);
    }

    /**
     * Adds a new review.
     *
     * @param review The review object to add.
     */
    @PostMapping("/add")
    public void addReview(@RequestBody Review review) {
        // Add the review and register the user as an observer
        reviewService.postReview(review);
        review.registerObserver(review.getUser());
    }

    /**
     * Updates a review with the specified ID.
     *
     * @param id     The ID of the review to update.
     * @param review The updated review object.
     */
    @PutMapping("/update/{id}")
    public void updateReview(@PathVariable("id") Integer id,
                             @RequestBody Review review) {
        reviewService.putReview(id, review);
    }

    /**
     * Increases the number of likes for a review.
     *
     * @param id The ID of the review to like.
     */
    @PutMapping("/like/{id}")
    public void likeReview(@PathVariable("id") Integer id) {
        // Increase the number of likes for the specified review
        Review review = reviewService.getReview(id);
        if (review != null) {
            review.likeReview();
            reviewService.putReview(id, review);
        }
    }
}
