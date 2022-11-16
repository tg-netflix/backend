package com.techgrounds.netflix.entity;

//import com.techgrounds.netflix.repository.MovieRepository;
import com.techgrounds.netflix.response.MovieResponse;
import com.techgrounds.netflix.response.SimilarMovieResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

// basicly MovieResponse but to store
/*@AllArgsConstructor
@Setter
@Getter
@Entity
public class MovieEntity {
    public String backdrop_path;
    public String poster_path;
    public long id;
    public String trailer;
    public String logo;
    public List<String> genres;
    public String title;
    public String overview;
    public List<String> keywords;
    public String release_date;
    public int runtime;
    public String age_certificate;
    public List<String> actors;
    public List<String> writers;
    public List<String> directors;
    public List<Long> similar;

    public static MovieEntity FromMovieResponse(MovieResponse original) {
        return new MovieEntity(
                original.getBackdrop_path(),
                original.getPoster_path(),
                original.getId(),
                original.getTrailer(),
                original.getLogo(),
                original.getGenres(),
                original.getTitle(),
                original.getOverview(),
                original.getKeywords(),
                original.getRelease_date(),
                original.getRuntime(),
                original.getAge_certificate(),
                original.getActors(),
                original.getWriters(),
                original.getDirectors(),
                original.getSimilar().stream()
                        .map(x -> x.getId())
                        .toList()
        );
    }

    public MovieResponse value() {
        return new MovieResponse(
                backdrop_path,
                poster_path,
                id,
                trailer,
                logo,
                genres,
                title,
                overview,
                keywords,
                release_date,
                runtime,
                age_certificate,
                actors,
                writers,
                directors,
                new ArrayList<SimilarMovieResponse>() //@bug
        );
    }

}
*/