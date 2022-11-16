package com.techgrounds.netflix.entity;

//import com.techgrounds.netflix.repository.MovieRepository;
import com.techgrounds.netflix.response.MovieResponse;
import com.techgrounds.netflix.response.SimilarMovieResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Setter
@Getter
@Entity
public class MovieEntity extends MovieResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer ID;
}