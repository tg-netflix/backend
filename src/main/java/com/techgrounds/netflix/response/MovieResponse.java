package com.techgrounds.netflix.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor //@Alex please add this
@Accessors(chain = true)
public class MovieResponse {
//    this class will contain all variables that the frontend wishes to receive
    private String backdrop_path;
    private String poster_path;
    private long id;
    private String trailer;
    private String logo;
    private List<String> genres;
    private String title;
    private String overview;
    private List<String> keywords;
    private String release_date;
    private int runtime;
    private String age_certificate;
    private List<String> actors;
    private List<String> writers;
    private List<String> directors;
    private List<SimilarMovieResponse> similar;
}
