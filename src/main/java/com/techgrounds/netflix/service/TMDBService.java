package com.techgrounds.netflix.service;
import com.techgrounds.netflix.dto.TMDBMovieDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="tmdb", url="https://api.themoviedb.org/3")
public interface TMDBService {
//    @GetMapping("/discover/movie")
//    public TMDBMovieResult discoverMovie(@RequestParam("api_key") String apiKey);
//
//    //    @GetMapping(value = "/movie/popular", produces = MediaType.APPLICATION_JSON_VALUE)
////    List<Movie> popularMovie(@RequestParam("api_key") String apiKey);
//    @GetMapping("/movie/popular")
//    List<MockupMovie> popularMovie(@RequestParam("api_key") String apiKey);
//
//    @GetMapping("/movie/{id}")
//    MockupMovie getMovie(@PathVariable Long id, @RequestParam("api_key") String apiKey);
//
//    @GetMapping("/movie/{id}/videos")
//    public String getMovieVideos(@PathVariable Long id, @RequestParam("api_key") String apiKey);



//    in deze interface wordt de data uit TMDB opgevraagd met de endpoint namen van de TMDB website. Deze
//    data kan dan weer opgeroepen worden in andere classes, zoals de controller

    @GetMapping("/movie/{id}")
    TMDBMovieDTO getMovie(@PathVariable Long id, @RequestParam("api_key") String apiKey);
}