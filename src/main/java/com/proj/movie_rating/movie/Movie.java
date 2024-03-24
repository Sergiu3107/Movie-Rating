package com.proj.movie_rating.movie;

import com.proj.movie_rating.review.Review;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Movie {

    @Id
    @SequenceGenerator(
            name = "movie_sequence",
            sequenceName = "movie_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "movie_sequence"
    )
    private Integer id;
    private String title;
    private Integer releaseYear;
    private Float rating;
    private String genre;
    private String director;
    @Column(length = 1000)
    private String description;
    @Column(length = 1000)
    private String image;

    @OneToMany(mappedBy = "movie")
    private List<Review> reviews;

    public Movie() {
    }

    public Movie(Integer id, String title, Integer releaseYear, Float rating, String genre, String director, String description, String image) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.genre = genre;
        this.director = director;
        this.description = description;
        this.image = image;
    }

    public Movie(String title, Integer releaseYear, Float rating, String genre, String director, String description, String image) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.genre = genre;
        this.director = director;
        this.description = description;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", genre='" + genre + '\'' +
                ", director='" + director + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }


}
