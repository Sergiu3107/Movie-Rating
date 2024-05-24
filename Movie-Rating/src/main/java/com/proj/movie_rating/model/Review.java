package com.proj.movie_rating.model;

import com.proj.movie_rating.observer.Observable;
import com.proj.movie_rating.observer.Observer;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Review Table
 * Comment provided by a user on a movie
 */
@Entity
@Table
public class Review implements Observable {

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
    private Float rating;
    @Column(length = 1000)
    private String review;
    private Integer likes;

    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id")
    private Movie movie;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    // Observers list for Review
    @Transient
    private List<Observer> observers = new ArrayList<>();

    public Review() {
    }

    public Review(User user, Movie movie, Float rating, String review, Integer likes) {
        this.user = user;
        this.movie = movie;
        this.rating = rating;
        this.review = review;
        this.likes = likes;
    }

    public Review(Integer id, User user, Movie movie, Float rating, String review, Integer likes) {
        this.id = id;
        this.user = user;
        this.movie = movie;
        this.rating = rating;
        this.review = review;
        this.likes = likes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
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

    public void likeReview(){
        this.likes++;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
