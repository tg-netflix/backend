package com.techgrounds.netflix.service;

import com.techgrounds.netflix.model.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="tmdb", url="https://api.themoviedb.org/3")
public interface TMDBService {
    @GetMapping("/discover/movie")
    public String discoverMovie(@RequestParam("api_key") String apiKey);
    //    public List<MovieDto> discoverMovie(@RequestParam("api_key") String apiKey);
    @GetMapping("/movie/popular")
    public String popularMovie(@RequestParam("api_key") String apiKey);
    @GetMapping("/movie/{id}")
    public String getMovie(@PathVariable Long id, @RequestParam("api_key") String apiKey);
    @GetMapping("/movie/{id}/videos")
    public String getMovieVideos(@PathVariable Long id, @RequestParam("api_key") String apiKey);

    @RequestMapping(method = RequestMethod.GET, value = "/movie/{movieId}", produces = "application/json")
    Movie getMovie(@PathVariable("movieId") Long movieId);
}