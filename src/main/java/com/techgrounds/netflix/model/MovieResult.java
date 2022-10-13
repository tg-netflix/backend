package com.techgrounds.netflix.model;

import com.techgrounds.netflix.model.TMDB.TMDBMovieResult;
import com.techgrounds.netflix.model.TMDB.TMDBMovie;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class MovieResult {
    public String page;
    public List<TMDBMovie> movies;

    public MovieResult(TMDBMovieResult result) {
        page = result.page;
        movies = result.results;
    }
}
