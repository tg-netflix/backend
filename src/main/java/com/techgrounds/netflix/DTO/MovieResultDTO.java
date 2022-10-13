package com.techgrounds.netflix.DTO;

import com.techgrounds.netflix.model.Movie;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class MovieResultDTO {
    public String page;
    public List<Movie> movies;

    public MovieResultDTO(TMDBMovieResultDTO result) {
        page = result.page;
        movies = result.results;
    }
}
