package com.techgrounds.netflix.controller;

import com.techgrounds.netflix.model.Movie;
import com.techgrounds.netflix.model.MovieDetails;
import com.techgrounds.netflix.service.TMDBService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Value("${apiKey}")
    private String apiKey;

    @Autowired
    private TMDBService tmdbService;

    @GetMapping("/")
    public String getData(){
        return apiKey;
    }

    @GetMapping("/movie")
    public Movie[] getDiscoverMovie(){
        return tmdbService.discoverMovie(apiKey);
    }

    @GetMapping("/movie/{id}")
    public MovieDetails getMovieDetails(@PathVariable Long id){
        return tmdbService.getMovie(id, apiKey);
    }

    @GetMapping("/movie/{id}/videos")
    public MovieDetails getMovieVideos(@PathVariable Long id) {
        return tmdbService.getMovie(id, apiKey);
    }

    @GetMapping("/movie/popular")
    public Movie[] getPopularMovie(){
        return tmdbService.popularMovie(apiKey);
    }
}
