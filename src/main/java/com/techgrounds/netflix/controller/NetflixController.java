package com.techgrounds.netflix.controller;

import com.techgrounds.netflix.response.MovieResponse;
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
    @Value("${apiKey}")
    private String apiKey;

    @Autowired
    private TMDBService tmdbService;

    @Autowired
    private NetflixService netflixService;

//    @GetMapping("/")
//    public String getData(){
//        return apiKey;
//    }

    //    @GetMapping("/movie")
//    public MovieResult getDiscoverMovie(){
//        return new MovieResult(tmdbService.discoverMovie(apiKey));
//    }

    //@GetMapping("/movie/{id}")
//public MockupMovie getMovieDetails(@PathVariable Long id){
////        meerdere regels business logic > uiteindelijk kan dit bij elkaar in een aparte service
////        IndividualMovieResult imr = MovieMapper.toIndividualMovie(tmdbService.getMovie(id, apiKey))
////        imr.setTrailer(iets uit ander tmdbservice endpoint)
////        etc.
//    return tmdbService.getMovie(id, apiKey);
//}
//
//    @GetMapping("/movie/{id}/videos")
//    public MockupMovie getMovieVideos(@PathVariable Long id){
//        return tmdbService.getMovie(id, apiKey);
//    }
//
//    @GetMapping("/movie/popular")
//    public List<MockupMovie> getPopularMovie(){
//        return tmdbService.popularMovie(apiKey);
//    }
//}



//    alles opnieuw schrijven. Endpoint namen zelf bedenken met behulp van Hui-Chee data en front end wensen. Voor /browse en
//    /movie

    @GetMapping("/")
    public String getGreeting() {
        return "Welcome to the homepage";
    }

    @GetMapping("/browse")
    public String browseMovies() {
        return "I will give movies to browse";
    }

    @GetMapping("/movie/{id}")
    public MovieResponse getMovieDetails(@PathVariable Long id, @RequestParam(required = false, defaultValue = "true")
    boolean details, @RequestParam(required = false) boolean similar){
        return netflixService.getSingleMovie(id, details, similar);

//    probeer apiKey in MovieService aan te maken
    }
}

