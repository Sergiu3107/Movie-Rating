package com.proj.movie_rating.repository;

import com.proj.movie_rating.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Review data manipulation from database
 */
@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
