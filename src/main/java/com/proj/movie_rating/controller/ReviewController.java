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
     * HTTP method: GET, for getting all the movies
     * @return a list of movies
     */
    @GetMapping("/show/all")
    public List<Review> showAllReviews(){
        return reviewService.getAllReviews();
    }

    @GetMapping("/show/{id}")
    public  Review showReview(@PathVariable("id") int id){
        return reviewService.getReview(id);
    }

    /**
     * HTTP method: DETELE, for deleting the review with a certain id
     * @param id
     * @return
     */
    @DeleteMapping("/remove/{id}")
    public boolean removeReview(@PathVariable("id") Integer id){
        return reviewService.deleteAReview(id);
    }

    /**
     * HTTP method: POST, for adding a new review
     * @param review
     */
    @PostMapping("/add")
    public void addReview(@RequestBody Review review){
        reviewService.postReview(review);
    }

    /**
     * HTTP method: PUT, for updating a review by id
     * @param id
     * @param review
     */
    @PutMapping("/update/{id}")
    public void updateReview(@PathVariable("id") Integer id,
                            @RequestBody Review review){
        reviewService.putReview(id, review);
    }
}
