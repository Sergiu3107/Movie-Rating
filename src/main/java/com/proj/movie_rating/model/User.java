package com.proj.movie_rating.model;

import com.proj.movie_rating.model.Review;
import jakarta.persistence.*;

import java.util.List;

/**
 * User Table
 * Status : regular - can add and delete its own review
 *          admin   - can add and delete anybody's reviews
 */
@Entity
@Table
public class User {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )

    private Integer id;
    private String username;
    private String password;
    private String email;
    private String status;

    @OneToMany(mappedBy = "user")
    private List<Review> reviews;

    public User() {
    }

    public User(String username, String password, String email, String status) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.status = status;
    }

    public User(Integer id, String username, String password, String email, String status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
