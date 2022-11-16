package com.techgrounds.netflix.controller;

import com.techgrounds.netflix.entity.User;
//import com.techgrounds.netflix.repository.MovieRepository;
import com.techgrounds.netflix.response.MovieResponse;
//import com.techgrounds.netflix.service.Cache.MovieCacheService;
//import com.techgrounds.netflix.service.MemoryUserService;
import com.techgrounds.netflix.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/*
@RestController("/cache/")
public class CacheController {
    @Autowired
    private MovieCacheService movieService;
    @Autowired
    private MemoryUserService userService;

    @GetMapping(value = "/users")
    public List<User> users() {
        return userService.All();
    }

    @GetMapping(value ="/movies")
    public MovieResponse[] movies() {
        return movieService.allMovies();
    }
}*/
