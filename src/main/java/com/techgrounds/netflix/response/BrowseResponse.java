package com.techgrounds.netflix.response;

import com.techgrounds.netflix.dto.tmdb.TMDBMovie;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class BrowseResponse {
    private Integer page;
    private String name;
    private List<TMDBMovie> movies;
}
