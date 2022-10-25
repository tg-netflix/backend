package com.techgrounds.netflix.service;

import com.techgrounds.netflix.dto.tmdb.*;
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
                .setRelease_date(movie.getRelease_date())
                .setRuntime(movie.getRuntime());

        TMDBVideoDTO videos = tmdbService.getVideos(id, apiKey);
        List<String> trailers = videos.getResults().stream()
                .filter(trailer -> trailer.getType().equalsIgnoreCase("Trailer")
                        && trailer.getSite().equalsIgnoreCase("YouTube") && trailer.isOfficial())
                .map(TMDBTrailerDTO::getKey)
                .limit(1)
                .toList();
        movieResponse.setTrailer(trailers.toString());

        List<String> genres = movie.getGenres().stream()
                .map(TMDBGenreDTO::getName).toList();
        movieResponse.setGenres(genres);

        TMDBKeywordsDTO movieKeywords = tmdbService.getKeywords(id, apiKey);
        List<String> keywords = movieKeywords.getKeywords().stream()
                .map(TMDBKeywordNameDTO::getName).toList();
        movieResponse.setKeywords(keywords);

        TMDBCreditsDTO movieCredits = tmdbService.getCredits(id, apiKey);
        List<String> actors = movieCredits.getCast().stream()
                .filter(actor -> actor.getKnown_for_department().equalsIgnoreCase("Acting"))
                .map(TMDBCastDTO::getName)
                .limit(10)
                .toList();
        movieResponse.setActors(actors);

        List<String> writers = movieCredits.getCrew().stream()
                .filter(writer -> writer.getKnown_for_department().equalsIgnoreCase("Writing"))
                .map(TMDBCastDTO::getName)
                .toList();
        movieResponse.setWriters(writers);

        List<String> directors = movieCredits.getCrew().stream()
                .filter(director -> director.getKnown_for_department().equalsIgnoreCase("Directing"))
                .map(TMDBCastDTO::getName)
                .toList();
        movieResponse.setDirectors(directors);

        return movieResponse;
    }
}

