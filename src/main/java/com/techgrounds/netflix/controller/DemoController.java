package com.techgrounds.netflix.controller;

import com.techgrounds.netflix.DTO.MockupMovieDto;
import com.techgrounds.netflix.DTO.MovieResultDTO;
import com.techgrounds.netflix.service.TMDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    @Value("${apiKey}")
    private String apiKey;

    @Autowired
    private TMDBService tmdbService;

    @GetMapping("/")
    public String getData(){
        return apiKey;
    }

    @GetMapping("/movie")
    public MovieResultDTO getDiscoverMovie(){
        return new MovieResultDTO(tmdbService.discoverMovie(apiKey));
    }

    @GetMapping("/movie/{id}")
    public MockupMovieDto getMovieDetails(@PathVariable Long id){
        return tmdbService.getMovie(id, apiKey);
    }
    @GetMapping("/movie/{id}/videos")
    public MockupMovieDto getMovieVideos(@PathVariable Long id){
        return tmdbService.getMovie(id, apiKey);
    }

    @GetMapping("/movie/popular")
    public List<MockupMovieDto> getPopularMovie(){
        return tmdbService.popularMovie(apiKey);
    }
}
