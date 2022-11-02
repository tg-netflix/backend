package com.techgrounds.netflix.service;

import com.techgrounds.netflix.dto.tmdb.TMDBMovieDTO;
import com.techgrounds.netflix.dto.tmdb.TMDBReleaseDatesResultsDTO;
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

    @Value("${fanApiKey}")
    private String fanApiKey;

    @Autowired
    private TMDBService tmdbService;

    @Autowired
    private FanArtTVService fanArtTVService;


    public SearchResponse getSearchedMovies(String query){

        SearchResponse searchResponse = new SearchResponse();
        TMDBSearchDTO movies = tmdbService.searchMovies(apiKey, query);
        List<SearchedMoviesResponse> searchedMovieList = movies.getResults()
                .stream()
                .limit(50)
                .map(searchedMovie -> {
                    searchedMovie.setPoster_path("https://image.tmdb.org/t/p/w500" + searchedMovie.getPoster_path())
                            .setBackdrop_path("https://image.tmdb.org/t/p/original" + searchedMovie.getBackdrop_path());

                    TMDBMovieDTO moreMovieInfo = tmdbService.getMovie(searchedMovie.getId(), apiKey);
                    searchedMovie.setRuntime(moreMovieInfo.getRuntime());

                    TMDBReleaseDatesResultsDTO searchedMovieCertification = tmdbService.getCertification(searchedMovie.getId(), apiKey);
                    searchedMovie.setAge_certificate(searchedMovieCertification.getAllResults());
                    return searchedMovie;
                })
                .toList();
        searchResponse.setResults(searchedMovieList);

        return searchResponse;

    }
}
