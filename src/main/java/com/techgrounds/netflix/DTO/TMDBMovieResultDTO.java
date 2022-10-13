package com.techgrounds.netflix.DTO;

import com.techgrounds.netflix.model.Movie;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class TMDBMovieResultDTO {
    public String page;
    public List<Movie> results;
}
