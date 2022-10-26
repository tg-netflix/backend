package com.techgrounds.netflix.dto.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

@Data
public class TMDBGenre {
    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;
}
