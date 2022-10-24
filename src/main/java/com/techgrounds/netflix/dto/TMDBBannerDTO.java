package com.techgrounds.netflix.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class TMDBBannerDTO {

    private String backdrop_path;

    @JsonProperty("description")
    private String overview;
    private Long id;
    private String logo;
    private String title;
    private String trailer;
}