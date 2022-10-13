package com.techgrounds.netflix.service;
import com.techgrounds.netflix.model.TMDB.TMDBMovieResult;
import com.techgrounds.netflix.model.MockupMovie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="tmdb", url="https://api.themoviedb.org/3")
public interface TMDBService {
    @GetMapping("/discover/movie")
    public TMDBMovieResult discoverMovie(@RequestParam("api_key") String apiKey);

    //    @GetMapping(value = "/movie/popular", produces = MediaType.APPLICATION_JSON_VALUE)
//    List<Movie> popularMovie(@RequestParam("api_key") String apiKey);
    @RequestMapping(method = RequestMethod.GET, value = "/movie/popular", produces = "application/json")
    List<MockupMovie> popularMovie(@RequestParam("api_key") String apiKey);

    @RequestMapping(method = RequestMethod.GET, value = "/movie/{id}", produces = "application/json")
    MockupMovie getMovie(@PathVariable Long id, @RequestParam("api_key") String apiKey);

    @GetMapping("/movie/{id}/videos")
    public String getMovieVideos(@PathVariable Long id, @RequestParam("api_key") String apiKey);
}