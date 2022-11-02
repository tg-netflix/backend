package com.techgrounds.netflix.entity;

import com.techgrounds.netflix.dto.tmdb.TMDBMovieDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class TMDBMovieEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    public String backdrop_path;
    public String poster_path;
    public String title;
    public String overview;
    public String release_date;
    public int runtime;
    public List<TMDBGenre> genres;

    public List<String> getAllGenres(){
        return genres.stream()
            .map(TMDBGenre::getName)
            .toList();
    }

    @NoArgsConstructor
    @Getter
    @Setter
    static class TMDBGenre {
        private String name;
    }

    public static TMDBMovieEntity fromMovieDTO(TMDBMovieDTO original) {
        return new TMDBMovieEntity(
                original.getId(),
                original.getBackdrop_path(),
                original.getPoster_path(),
                original.getTitle(),
                original.getOverview(),
                original.getRelease_date(),
                original.getRuntime(),
                new ArrayList<>() //@Bug please fix
        );
    }
}
