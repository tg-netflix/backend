package com.techgrounds.netflix.controller;

import com.techgrounds.netflix.dto.tmdb.TMDBDiscover;
import com.techgrounds.netflix.model.MockupMovie;
import com.techgrounds.netflix.response.BrowseResponse;
import com.techgrounds.netflix.service.MovieService;
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

    @Autowired
    private MovieService movieService;

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

    
    @GetMapping(value = "/browse")
    public BrowseResponse getDiscoverMovie(
            @RequestParam String categories,
            @RequestParam(required = false, defaultValue = "false") boolean banner,
            @RequestParam(required = false, defaultValue = "1") int page){
        return movieService.getBrowseMovies(categories, banner, page);
    }

    @GetMapping("/movie/{id}")
    public MovieResponse getMovieDetails(@PathVariable Long id, @RequestParam(required = false, defaultValue = "true")
    boolean details, @RequestParam(required = false) boolean similar){
        return netflixService.getSingleMovie(id, details, similar);
    }
}

