package com.techgrounds.netflix.dto.tmdb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TMDBMovieDTO {
//    movie details will be added from TMDB endpoint /movie/{id}

    private long id;
    private String title;
    private String overview;
    private String release_date;
    private int runtime;
    private List<TMDBGenreDTO> genres;

    public List<String> getAllGenres(){
        return getGenres().stream()
                .map(TMDBGenreDTO::getName)
                .toList();
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @Accessors(chain = true)
    static class TMDBGenreDTO {

        private String name;

    }
}
