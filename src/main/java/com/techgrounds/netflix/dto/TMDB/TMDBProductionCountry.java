package com.techgrounds.netflix.dto.TMDB;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;

@JsonRootName("production_country")
@Getter
public class TMDBProductionCountry {
    @JsonProperty("iso_3166_1")
    private String isoCode;
    @JsonProperty("name")
    private String name;
}

