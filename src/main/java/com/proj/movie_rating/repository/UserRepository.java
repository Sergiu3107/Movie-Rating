package com.proj.movie_rating.repository;

import com.proj.movie_rating.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * For working with JPA
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
