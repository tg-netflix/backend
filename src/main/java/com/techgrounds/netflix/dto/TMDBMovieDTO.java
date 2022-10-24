package com.techgrounds.netflix.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TMDBMovieDTO {
    private int id;
    private List<?> genres;
    private String title;
    private String overview;
    private int release_date;
    private int runtime;

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
