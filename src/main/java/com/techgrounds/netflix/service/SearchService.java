package com.techgrounds.netflix.service;

import com.techgrounds.netflix.dto.tmdb.TMDBSearchDTO;
import com.techgrounds.netflix.response.SearchResponse;
import com.techgrounds.netflix.response.SearchedMoviesResponse;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Service
public class SearchService {

    @Value("${apiKey}")
    private String apiKey;

    @Autowired
    private TMDBService tmdbService;


//    method to call in controller for getting searched movies
    public SearchResponse getSearchedMovies(String query){
//        set information needed from searched movies

        SearchResponse searchResponse = new SearchResponse();
        TMDBSearchDTO movies = tmdbService.searchMovies(apiKey, query);
        List<SearchedMoviesResponse> searchedMovieList = movies.getResults()
                .stream()
                .limit(20)
                .map(searchedMovie -> {
//                    set backdrop
                    if(searchedMovie.getBackdrop_path() != null){
                        searchedMovie.setBackdrop_path("https://image.tmdb.org/t/p/original" + searchedMovie.getBackdrop_path());
                    }
                    else{
                        searchedMovie.setBackdrop_path("https://images3.alphacoders.com/678/678085.jpg");
                    }
                    return searchedMovie;
                })
                .toList();
        searchResponse.setResults(searchedMovieList);
        return searchResponse;
    }
}
