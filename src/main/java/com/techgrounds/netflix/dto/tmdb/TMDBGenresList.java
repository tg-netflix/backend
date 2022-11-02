package com.techgrounds.netflix.dto.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class TMDBGenresList {
    @JsonProperty("genres")
    List<TMDBGenre> genreList;
}
