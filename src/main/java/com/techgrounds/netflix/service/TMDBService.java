package com.techgrounds.netflix.service;

import com.techgrounds.netflix.dto.tmdb.TMDBDiscover;
import com.techgrounds.netflix.dto.tmdb.TMDBGenresList;
import com.techgrounds.netflix.model.MockupMovie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name="tmdb", url="https://api.themoviedb.org/3")
public interface TMDBService {
    @GetMapping("/genre/movie/list")
    TMDBGenresList getGenresList(@RequestParam("api_key") String apiKey);
    @GetMapping(value = "/movie/popular", produces = "application/json")
    TMDBDiscover popularMovie(@RequestParam("api_key") String apiKey,
                              @RequestParam(value = "page", required = false,  defaultValue = "1") int page);
    @GetMapping(value = "/movie/top_rated", produces = "application/json")
    TMDBDiscover topRatedMovie(@RequestParam("api_key") String apiKey,
                               @RequestParam(value = "page", required = false,  defaultValue = "1") int page);
    @GetMapping(value = "/discover/movie", produces = "application/json")
    TMDBDiscover movieNonGenre(@RequestParam("api_key") String apiKey,
                               @RequestParam(value = "with_genres", required = false,  defaultValue = "") String genreId,
                               @RequestParam(value = "sort_by", required = false,  defaultValue = "popularity.desc") String sortBy,
                               @RequestParam(value = "release_date.lte", required = false,  defaultValue = "#{T(java.time.LocalDate).now()}") String date,
                               @RequestParam(value = "with_company", required = false, defaultValue = "") String companyId,
                               @RequestParam(value = "primary_release_year", required = false) int yearRand,
                               @RequestParam(value = "page", required = false,  defaultValue = "1") int page);

    @RequestMapping(method = RequestMethod.GET, value = "/movie/{id}", produces = "application/json")
    MockupMovie getMovie(@PathVariable Long id, @RequestParam("api_key") String apiKey);
//
//    @GetMapping(value = "/movie/{id}/videos", produces = "application/json")
//    String getMovieVideos(@PathVariable Long id, @RequestParam("api_key") String apiKey);



//    @GetMapping(value = "/discover/movie", produces = "application/json")
//    TMDBDiscover discoverMovie(@RequestParam("api_key") String apiKey);
//    @GetMapping(value = "/discover/movie", produces = "application/json")
//    TMDBDiscover latestMovie(@RequestParam("api_key") String apiKey,
//                             @RequestParam("sort_by") String sortBy,
//                             @RequestParam("release_date.lte") String date);
//    @GetMapping(value = "/discover/movie", produces = "application/json")
//    TMDBDiscover movieWithGenre(@RequestParam("api_key") String apiKey,
//                                @RequestParam("with_genres") String genreId);
//
}