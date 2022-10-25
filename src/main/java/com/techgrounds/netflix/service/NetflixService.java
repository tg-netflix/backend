package com.techgrounds.netflix.service;

import com.techgrounds.netflix.dto.GenreDTO;
import com.techgrounds.netflix.dto.TMDBCreditsDTO;
import com.techgrounds.netflix.dto.TMDBMovieDTO;
import com.techgrounds.netflix.response.MovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NetflixService {
//    hier wordt de data omgezet in een method die in de controller returned kan worden wanneer een
//    endpoint wordt aangesproken
    @Value("${apiKey}")
    private String apiKey;

    @Autowired
    private TMDBService tmdbService;

    public MovieResponse getSingleMovie(Long id, boolean details, boolean similar){
        MovieResponse movieResponse = new MovieResponse();
        TMDBMovieDTO movie = tmdbService.getMovie(id, apiKey);
        movieResponse.setId(movie.getId())
                .setTitle(movie.getTitle())
                .setDescription(movie.getOverview())
                .setRelease_year(movie.getRelease_date())
                .setRuntime(movie.getRuntime());

        List<String> genres = movie.getGenres().stream()
                .map(GenreDTO::getName).toList();
        movieResponse.setGenres(genres);

        TMDBCreditsDTO movieCredits = tmdbService.getCredits(id, apiKey);


        System.out.println(movieResponse);
        return movieResponse;
    }
}

