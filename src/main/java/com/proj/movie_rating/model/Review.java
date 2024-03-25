package com.proj.movie_rating.model;

import jakarta.persistence.*;

/**
 * Review Table
 * Comment provided by a user on a movie
 */
@Entity
@Table
public class Review {

    @Id
    @SequenceGenerator(
            name = "review_sequence",
            sequenceName = "review_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "review_sequence"
    )

    private Integer id;
//    private Integer user_id;
//    private Integer movie_id;
    private Float rating;
    @Column(length = 1000)
    private String review;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Review() {
    }

    public Review(Integer user_id, Integer movie_id, Float rating, String review) {
//        this.user_id = user_id;
//        this.movie_id = movie_id;
        this.rating = rating;
        this.review = review;
    }

    public Review(Integer id, Integer user_id, Integer movie_id, Float rating, String review) {
        this.id = id;
//        this.user_id = user_id;
//        this.movie_id = movie_id;
        this.rating = rating;
        this.review = review;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /*
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(Integer movie_id) {
        this.movie_id = movie_id;
    }
    */

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
//                ", user_id=" + user_id +
//                ", movie_id=" + movie_id +
                ", rating=" + rating +
                ", review='" + review + '\'' +
                '}';
    }
}
