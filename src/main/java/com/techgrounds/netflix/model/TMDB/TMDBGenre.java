package com.techgrounds.netflix.model.TMDB;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class TMDBGenre {
    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;
}
