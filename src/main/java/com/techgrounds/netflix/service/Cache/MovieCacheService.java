package com.techgrounds.netflix.service.Cache;

//import com.techgrounds.netflix.entity.MovieEntity;
//import com.techgrounds.netflix.repository.MovieRepository;
import com.techgrounds.netflix.response.MovieResponse;
import com.techgrounds.netflix.service.MovieService;
import com.techgrounds.netflix.service.TMDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/*
@Service
public class MovieCacheService {
    @Autowired
    private MovieService movieService;
    @Autowired
    private MovieRepository movieRepository;

    public MovieResponse singleMovie(long id) {
        if (movieRepository.existsById(id))
            return movieRepository.findById(id).get().value();
        var result = movieService.getSingleMovie(id, true);
        movieRepository.save(MovieEntity.FromMovieResponse(result));
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
}*/
