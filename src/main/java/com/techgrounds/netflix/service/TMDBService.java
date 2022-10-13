package com.techgrounds.netflix.service;

import com.techgrounds.netflix.model.Movie;
import com.techgrounds.netflix.model.MovieDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@FeignClient(name="tmdb", url="https://api.themoviedb.org/3")
public interface TMDBService {
    @GetMapping("/discover/movie")
    Movie[] discoverMovie(@RequestParam("api_key") String apiKey);

    @GetMapping("/movie/popular")
    Movie[] popularMovie(@RequestParam("api_key") String apiKey);

    @GetMapping("/movie/{id}")
    MovieDetails getMovie(@PathVariable Long id, @RequestParam("api_key") String apiKey);

    @GetMapping("/movie/{id}/videos")
    String getMovieVideos(@PathVariable Long id, @RequestParam("api_key") String apiKey);

    @RequestMapping(method = RequestMethod.GET, value = "/movie/{movieId}", produces = "application/json")

    Movie getMovie(@PathVariable("movieId") Long movieId);
}