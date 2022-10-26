package com.techgrounds.netflix.controller;

import com.techgrounds.netflix.response.MovieResponse;
import com.techgrounds.netflix.service.FanArtTVService;
import com.techgrounds.netflix.service.NetflixService;
import com.techgrounds.netflix.service.TMDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NetflixController {
//    this controller will return methods from other classes when endpoints are called

    @Value("${apiKey}")
    private String apiKey;
    @Value("${fanApiKey}")
    private String fanApiKey;
    @Autowired
    private TMDBService tmdbService;
    @Autowired
    private NetflixService netflixService;
    @Autowired
    private FanArtTVService fanArtTVService;

    @GetMapping("/")
    public String getGreeting() {
        return "Welcome to the homepage";
    }

    @GetMapping("/browse")
    public String browseMovies() {
        return "I will give movies to browse";
    }

    @GetMapping("/movie/{id}")
    public MovieResponse getMovieDetails(@PathVariable Long id, @RequestParam(required = false, defaultValue = "true")
    boolean details, @RequestParam(required = false) boolean similar){
        return netflixService.getSingleMovie(id, details, similar);
    }

    @GetMapping("/testlogo")
    public String getData(){
        return fanApiKey;
    }
}

