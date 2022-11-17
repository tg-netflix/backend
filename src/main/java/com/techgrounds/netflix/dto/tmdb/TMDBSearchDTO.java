package com.techgrounds.netflix.dto.tmdb;

import com.techgrounds.netflix.response.SearchedMoviesResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Accessors(chain = true)
public class TMDBSearchDTO {
//    searched movies will be added from TMDB endpoint /search/movie
//    gets list of variables determined in SearchedMoviesResponse

    private List<SearchedMoviesResponse> results;

}
