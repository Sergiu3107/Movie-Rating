package com.proj.movie_rating.service_contract;

import com.proj.movie_rating.model.Movie;
import com.proj.movie_rating.model.Review;

import java.util.List;

public interface ReviewServiceContract {

    public List<Review> getAllReviews();
    public Review getReview(int id);
    public boolean deleteAReview(Integer id);
    public void postReview(Review review);
    public boolean putReview(Integer id, Review review);
}
