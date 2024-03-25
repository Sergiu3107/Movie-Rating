package com.proj.movie_rating.repository;

import com.proj.movie_rating.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * For working with JPA
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
