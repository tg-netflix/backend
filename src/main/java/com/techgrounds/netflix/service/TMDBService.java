package com.techgrounds.netflix.service;
import com.techgrounds.netflix.dto.tmdb.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="tmdb", url="https://api.themoviedb.org/3")
public interface TMDBService {
//    in deze interface wordt de data uit TMDB opgevraagd met de endpoint namen van de TMDB website. Deze
//    data kan dan weer opgeroepen worden in andere classes, zoals de controller

    @GetMapping("/movie/{id}")
    TMDBMovieDTO getMovie(@PathVariable Long id, @RequestParam("api_key") String apiKey);

    @GetMapping("/movie/{id}/videos")
    TMDBVideoDTO getVideos(@PathVariable Long id, @RequestParam("api_key") String apiKey);

    @GetMapping("/movie/{id}/keywords")
    TMDBKeywordsDTO getKeywords(@PathVariable Long id, @RequestParam("api_key") String apiKey);

    @GetMapping("/movie/{id}/release_dates")
    TMDBReleaseDatesResults getCertification(@PathVariable Long id, @RequestParam("api_key") String apiKey);

    @GetMapping("/movie/{id}/credits")
    TMDBCreditsDTO getCredits(@PathVariable Long id, @RequestParam("api_key") String apiKey);

    @GetMapping("/movie/{id}/similar")
    TMDBSimilarDTO getSimilarMovies(@PathVariable Long id, @RequestParam("api_key") String apiKey);
}