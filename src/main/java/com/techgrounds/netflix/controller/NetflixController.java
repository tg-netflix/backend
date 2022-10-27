package com.techgrounds.netflix.controller;

import com.techgrounds.netflix.response.BrowseResponse;
import com.techgrounds.netflix.response.MovieResponse;
import com.techgrounds.netflix.service.NetflixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NetflixController {

    @Value("${apiKey}")
    private String apiKey;
    
    @Value("${fanApiKey}")
    private String fanApiKey;

    @Autowired
    private NetflixService netflixService;

    @GetMapping(value = "/browse")
    public BrowseResponse getDiscoverMovie(
            @RequestParam String categories,
            @RequestParam(required = false, defaultValue = "false") boolean banner,
            @RequestParam(required = false, defaultValue = "1") int page){
        return netflixService.getBrowseMovies(categories, banner, page);
    }

    @GetMapping("/movie/{id}")
    public MovieResponse getMovieDetails(@PathVariable Long id, @RequestParam(required = false) boolean similar){
        return netflixService.getSingleMovie(id, similar);
    }
}

