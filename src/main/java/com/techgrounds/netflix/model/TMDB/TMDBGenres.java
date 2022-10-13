package com.techgrounds.netflix.model.TMDB;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class TMDBGenres {
    @JsonProperty("genres")
    List<TMDBGenre> genreList;
}
