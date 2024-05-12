package com.proj.movie_rating.repository;

import com.proj.movie_rating.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for performing CRUD operations on Review entities in the database.
 */
@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
