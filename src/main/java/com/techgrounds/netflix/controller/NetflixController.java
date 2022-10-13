package com.techgrounds.netflix.controller;

import com.techgrounds.netflix.model.MockupMovie;
import com.techgrounds.netflix.model.MovieResult;
import com.techgrounds.netflix.service.TMDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NetflixController {
    @Value("${apiKey}")
    private String apiKey;

    @Autowired
    private TMDBService tmdbService;

    @GetMapping("/")
    public String getData(){
        return apiKey;
    }

    @GetMapping("/movie")
    public MovieResult getDiscoverMovie(){
        return new MovieResult(tmdbService.discoverMovie(apiKey));
    }

    @GetMapping("/movie/{id}")
    public MockupMovie getMovieDetails(@PathVariable Long id){
        return tmdbService.getMovie(id, apiKey);
    }
    @GetMapping("/movie/{id}/videos")
    public MockupMovie getMovieVideos(@PathVariable Long id){
        return tmdbService.getMovie(id, apiKey);
    }

    @GetMapping("/movie/popular")
    public List<MockupMovie> getPopularMovie(){
        return tmdbService.popularMovie(apiKey);
    }
}
