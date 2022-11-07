package com.techgrounds.netflix.controller;

import com.techgrounds.netflix.response.BrowseResponse;
import com.techgrounds.netflix.response.MovieResponse;
import com.techgrounds.netflix.response.SearchResponse;
import com.techgrounds.netflix.service.BrowseService;
import com.techgrounds.netflix.service.MovieService;
import com.techgrounds.netflix.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(maxAge = 3600)
@RestController
public class NetflixController {

    @Value("${apiKey}")
    private String apiKey;
    
    @Value("${fanApiKey}")
    private String fanApiKey;

    @Autowired
    private MovieService movieService;

    @Autowired
    private BrowseService browseService;

    @Autowired
    private SearchService searchService;

    @GetMapping(value = "/browse")
    public BrowseResponse getDiscoverMovie(
            @RequestParam String categories,
            @RequestParam(required = false, defaultValue = "false") boolean banner,
            @RequestParam(required = false, defaultValue = "1") int page){
        return browseService.getBrowseMovies(categories, banner, page);
    }

    @GetMapping("/movie/{id}")
    public MovieResponse getMovieDetails(@PathVariable Long id, @RequestParam(required = false) boolean similar){
        return movieService.getSingleMovie(id, similar);
    }

    @GetMapping("/search/movie")
    public SearchResponse getMovieList(@RequestParam String query){
        return searchService.getSearchedMovies(query);
    }
}

