package com.techgrounds.netflix.response;

import com.techgrounds.netflix.service.TMDBService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class MovieResponse {
//    @Value("${apiKey}")
//    private String apiKey;
//
//    @Autowired
//    private TMDBService tmdbService;

    private long id;
//    private String trailer;
//    private String logo;
//    private List<?> genres;
    private String title;
    private String description;
//    private List<String> keywords;
    private String release_year;
    private int runtime;
    private int age_certificate;
    private List<String> actors;
//    private List<String> writers;
//    private List<String> directors;
//    private List<?> similar;

//    public TMDBMovieDTO getMovieDetails(){
//        TMDBMovieDTO tmdbMovieDTO = new TMDBMovieDTO();
//        TMDBMovieDTO movie = tmdbService.getMovie(id, apiKey);
//        tmdbMovieDTO.setId(movie.getId())
//                .setTitle(movie.getTitle())
//                .setOverview(movie.getOverview())
//                .setRelease_date(movie.getRelease_date());
//        return tmdbMovieDTO;
//    }
}