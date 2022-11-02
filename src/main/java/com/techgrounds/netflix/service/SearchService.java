package com.techgrounds.netflix.service;

import com.techgrounds.netflix.dto.tmdb.TMDBMovieDTO;
import com.techgrounds.netflix.dto.tmdb.TMDBReleaseDatesResultsDTO;
import com.techgrounds.netflix.dto.tmdb.TMDBSearchDTO;
import org.springframework.stereotype.Service;
import com.techgrounds.netflix.response.MovieResponse;
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


    public MovieResponse getSearchedMovies(String query){

        MovieResponse searchResponse = new MovieResponse();
        TMDBSearchDTO movies = tmdbService.searchMovies(apiKey, query);
        List<MovieResponse> searchedMovieList = movies.getResults()
                .stream()
                .limit(50)
                .map(searchedMovie -> {
                    TMDBMovieDTO moreMovieInfo = tmdbService.getMovie(searchedMovie.getId(), apiKey);
                    searchedMovie.setRuntime(moreMovieInfo.getRuntime());

                    TMDBReleaseDatesResultsDTO searchedMovieCertification = tmdbService.getCertification(searchedMovie.getId(), apiKey);
                    searchedMovie.setAge_certificate(searchedMovieCertification.getAllResults());
                    return searchedMovie;
                })
                .toList();


        return searchResponse;

    }
}
