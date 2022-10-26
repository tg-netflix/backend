package com.techgrounds.netflix.service;

import com.techgrounds.netflix.dto.tmdb.*;
import com.techgrounds.netflix.response.MovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NetflixService {
//    in this class the MovieResponse variables will be set

    @Value("${apiKey}")
    private String apiKey;

    @Autowired
    private TMDBService tmdbService;


//    method to call in controller for getting al details of a single movie
    public MovieResponse getSingleMovie(Long id, boolean details, boolean similar){
        MovieResponse movieResponse = new MovieResponse();

//        set basic movie information
        TMDBMovieDTO movie = tmdbService.getMovie(id, apiKey);
        movieResponse.setId(movie.getId())
                .setTitle(movie.getTitle())
                .setDescription(movie.getOverview())
                .setRelease_date(movie.getRelease_date())
                .setRuntime(movie.getRuntime());

//        set trailer
        TMDBVideoDTO videos = tmdbService.getVideos(id, apiKey);
        movieResponse.setTrailer(videos.getTrailerResult());

//        set genres
        movieResponse.setGenres(movie.getAllGenres());

//        set keywords
        TMDBKeywordsDTO movieKeywords = tmdbService.getKeywords(id, apiKey);
        List<String> keywords = movieKeywords.getListOfKeywords();
        movieResponse.setKeywords(keywords);

//        set age_certificate
        TMDBReleaseDatesResults movieCertification = tmdbService.getCertification(id, apiKey);
        movieResponse.setAge_certificate(movieCertification.getAllResults());

//        set actors
        TMDBCreditsDTO movieCredits = tmdbService.getCredits(id, apiKey);
        List<String> actors = movieCredits.getAllActors();
        movieResponse.setActors(actors);

//        set writers
        List<String> writers = movieCredits.getAllWriters();
        movieResponse.setWriters(writers);

//        set directors
        List<String> directors = movieCredits.getAllDirectors();
        movieResponse.setDirectors(directors);

//        return movieResponse with all set variables
        return movieResponse;
    }
}

