package com.techgrounds.netflix.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class SearchedMoviesResponse {
//    searched movies will be added from TMDB endpoint /search/movie
//    in here the needed variables for the results list will be determined

    private String backdrop_path;
    private long id;
    private String title;

}
