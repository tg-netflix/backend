package com.techgrounds.netflix.service;

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
        System.out.println(id);
        System.out.println(details);
        System.out.println(similar);
        MovieResponse movieResponse = new MovieResponse();
//        movieResponse.setId(550)
//                .setActors(List.of("Brad Pitt", "Edward Norton", "Helena Bonham Carter", "Meat Loaf"))
//                .setAge_certificate(16)
//                .setTitle("Fight Club");
        var movie = tmdbService.getMovie(id, apiKey);
        movieResponse.setId(movie.getId());
        return movieResponse;
    }
//    hier de MockupMovie data mooier maken zodat het teruggegeven wordt zoals de frontend dat wil
}
