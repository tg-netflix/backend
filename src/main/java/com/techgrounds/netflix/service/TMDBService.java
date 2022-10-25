package com.techgrounds.netflix.service;

import com.techgrounds.netflix.dto.MovieDto;
import com.techgrounds.netflix.dto.tmdb.TMDBDiscover;
import com.techgrounds.netflix.model.MockupMovie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="tmdb", url="https://api.themoviedb.org/3")
public interface TMDBService {
    @GetMapping(value = "/discover/movie", produces = "application/json")
    TMDBDiscover discoverMovie(@RequestParam("api_key") String apiKey);

    @GetMapping(value = "/movie/popular", produces = "application/json")
    TMDBDiscover popularMovie(@RequestParam("api_key") String apiKey);
    @GetMapping(value = "/movie/top_rated", produces = "application/json")
    TMDBDiscover topRatedMovie(@RequestParam("api_key") String apiKey);
    @GetMapping(value = "/discover/movie", produces = "application/json")
    TMDBDiscover latestMovie(@RequestParam("api_key") String apiKey,
                       @RequestParam("sort_by") String sortBy,
                       @RequestParam("release_date.lte") String date);

    @RequestMapping(method = RequestMethod.GET, value = "/movie/{id}", produces = "application/json")
    MockupMovie getMovie(@PathVariable Long id, @RequestParam("api_key") String apiKey);

    @GetMapping(value = "/movie/{id}/videos", produces = "application/json")
    String getMovieVideos(@PathVariable Long id, @RequestParam("api_key") String apiKey);
}