package com.techgrounds.netflix.model.TMDB;

import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class TMDBMovieResult {
    public String page;
    public List<TMDBMovie> results;
}
