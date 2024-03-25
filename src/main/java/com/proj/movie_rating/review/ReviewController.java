package com.proj.movie_rating.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/review")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    /**
     * HTTP method: GET, for getting all the reviews
     * @return a list of reviews
     */
    @GetMapping("/show/all")
    public List<Review> getReviews(){
        return reviewService.getReviews();
    }
}
