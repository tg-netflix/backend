package com.techgrounds.netflix.repository;

import com.techgrounds.netflix.dto.tmdb.TMDBMovieDTO;
import com.techgrounds.netflix.response.MovieResponse;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<MovieResponse, Long> {}
