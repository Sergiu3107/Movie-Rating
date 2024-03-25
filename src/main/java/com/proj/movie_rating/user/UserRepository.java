package com.proj.movie_rating.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * For working with JPA
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
