package com.proj.movie_rating.movie;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * For working with JPA
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
