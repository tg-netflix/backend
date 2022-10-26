package com.techgrounds.netflix.response;

import com.techgrounds.netflix.dto.MovieDto;
import com.techgrounds.netflix.dto.tmdb.TMDBMovie;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class BrowseResponse {
    private Object banner;
    private List<?> categories;
}
