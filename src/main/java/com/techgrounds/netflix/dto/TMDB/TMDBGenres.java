package com.techgrounds.netflix.dto.TMDB;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class TMDBGenres {
    @JsonProperty("genres")
    List<TMDBGenre> genreList;
}
