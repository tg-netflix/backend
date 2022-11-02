package com.techgrounds.netflix.response;

import com.techgrounds.netflix.dto.tmdb.TMDBSearchDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class SearchResponse {
//    gets list of variables determined in SearchedMoviesResponse

    private List<SearchedMoviesResponse> results;

}
