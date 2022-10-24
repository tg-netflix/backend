package com.techgrounds.netflix.service;

import com.techgrounds.netflix.dto.TMDBMovieDTO;
import com.techgrounds.netflix.response.MovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NetflixService {
    @Value("${apiKey}")
    private String apiKey;

    @Autowired
    private TMDBService tmdbService;

    public MovieResponse getSingleMovie(Long id, boolean details, boolean similar){
        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setId(550)
                .setActors(List.of("Brad Pitt", "Edward Norton", "Helena Bonham Carter", "Meat Loaf"))
                .setAge_certificate(16)
                .setTitle("Fight Club");
//        setting with mock data works, setting with api data won't work
//        TMDBMovieDTO movie = tmdbService.getMovie(id, apiKey);
//        movieResponse.setId(movie.getId())
//                .setTitle(movie.getTitle())
//                .setDescription(movie.getOverview())
//                .setRelease_year(movie.getRelease_date())
//                .setRuntime(movie.getRuntime());
////                .setGenres(movie.getGenres());
        System.out.println(movieResponse);
//        System.out.println(movieResponse.getTitle());

//        TMDBMovieDTO tmdbMovieDTO = tmdbService.getMovie(id, apiKey);
//        movieResponse.setTitle(tmdbMovieDTO.getTitle())
//                .setRuntime(tmdbMovieDTO.getRuntime())
//                .setDescription(tmdbMovieDTO.getOverview())
//                .setId(tmdbMovieDTO.getId()).setRelease_year(tmdbMovieDTO.getRelease_date());
//        hoe de fuck set je de values in de movieDTO om ze hier te kunnen getten???!?!?!??!?!?!?!?!?
        return movieResponse;
    }
//    hier de MockupMovie data mooier maken zodat het teruggegeven wordt zoals de frontend dat wil
}
