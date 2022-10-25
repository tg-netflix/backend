package com.techgrounds.netflix.dto;

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

    private long id;
    private String title;
    private String overview;
    private String release_date;
    private int runtime;
    private List<GenreDTO> genres;


//    TMDBCreditsDTO and TMDBCastDTO will be getting information for NetflixService about cast. Are these variables needed?
//    Keeping them commented out just in case

//    private int adult; for age_certificate?
//    private List<String> actors;
//    private List<String> writers;
//    private List<String> directors;
//    private List<?> similar;
//    production_companies
//    production_countries
//    Ook toevoegen aan informatie?
//    original_language
//    original_title vs title?
//    popularity?
}
