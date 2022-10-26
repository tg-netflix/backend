package com.techgrounds.netflix.controller;

import com.techgrounds.netflix.dto.tmdb.TMDBDiscover;
import com.techgrounds.netflix.model.MockupMovie;
import com.techgrounds.netflix.response.BrowseResponse;
import com.techgrounds.netflix.service.MovieService;
import com.techgrounds.netflix.service.TMDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NetflixController {

    @Autowired
    private MovieService movieService;

    @GetMapping(value = "/browse")
    public BrowseResponse getDiscoverMovie(
            @RequestParam String categories,
            @RequestParam(required = false, defaultValue = "false") boolean banner,
            @RequestParam(required = false, defaultValue = "1") int page){
        return movieService.getBrowseMovies(categories, banner, page);
    }

//    @GetMapping("/movie/{id}")
//    public MockupMovie getMovieDetails(@PathVariable Long id){
//        return tmdbService.getMovie(id, apiKey);
//    }
//    @GetMapping("/movie/{id}/videos")
//    public String getMovieVideos(@PathVariable Long id){
//        return tmdbService.getMovieVideos(id, apiKey);
//    }
//
//    @GetMapping("/movie/popular")
//    public List<MockupMovie> getPopularMovie(){
//        return tmdbService.popularMovie(apiKey);
//    }
}
