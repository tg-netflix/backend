package com.techgrounds.netflix.service.Cache;

import com.techgrounds.netflix.repository.MovieRepository;
import com.techgrounds.netflix.response.MovieResponse;
import com.techgrounds.netflix.service.NetflixService;
import com.techgrounds.netflix.service.TMDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class MovieCacheService {
    @Autowired
    private NetflixService netflixService;
    @Autowired
    private MovieRepository movieRepository;

    public MovieResponse singleMovie(long id) {
        if (movieRepository.existsById(id))
            return movieRepository.findById(id).get();
        var result = netflixService.getSingleMovie(id, true);
        movieRepository.save(result);
        return result;
    }

    public MovieResponse[] movies(List<Long> ids) {
        return (MovieResponse[]) ids.stream()
                .map(x -> singleMovie(x))
                .toArray();
    }

    public MovieResponse[] allMovies() {
        var iter = movieRepository.findAll().spliterator();
        return (MovieResponse[]) StreamSupport.stream(iter, false)
                .toArray();
    }
}
