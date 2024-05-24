package com.proj.movie_rating.repository;

import com.proj.movie_rating.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for performing CRUD operations on User entities in the database.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
