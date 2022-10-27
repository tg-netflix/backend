package com.techgrounds.netflix.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class SimilarMovieDTO {
//    similar will be added from TMDB endpoint /movie/{id}/similar
//    in here the needed variables for the results list will be determined

    private String backdrop_path;
    private String overview;
    private long id;
    private String title;
    private int runtime;
    private String release_date;
    private String age_certificate;

}
