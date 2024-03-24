package com.proj.movie_rating.movie;

import org.springframework.stereotype.Component;

@Component
public class MovieService {

    public Movie getMovie(){
        return new Movie(
                1,
                "movie1",
                2000,
                "ok",
                "ok",
                "ok",
                "ok"
        );
    }
}
