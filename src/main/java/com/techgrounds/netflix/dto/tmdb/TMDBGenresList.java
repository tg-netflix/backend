package com.techgrounds.netflix.dto.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@NoArgsConstructor
@Accessors(chain = true)
public class TMDBGenresList {
    List<TMDBGenre> genreList;
//
//    @Data
//    @NoArgsConstructor
//    @Accessors(chain = true)
//    static class TMDBGenre {
//        private int id;
//
//        private String name;
//    }

}
