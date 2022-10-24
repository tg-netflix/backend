package com.techgrounds.netflix.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.techgrounds.netflix.service.TMDBService;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TMDBMovieDTO {
//    @Value("${apiKey}")
//    private String apiKey;
//
//    @Autowired
//    private TMDBService tmdbService;
    private long id;
//    private List<?> genres;
    private String title;
    private String overview;
    private String release_date;
    private int runtime;


//    @JsonCreator
//    public TMDBMovieDTO(@JsonProperty("id") Long id, @JsonProperty("title") String title,
//                            @JsonProperty("release_date") String release_date, @JsonProperty("overview") String overview,
//                            @JsonProperty("runtime") int runtime) {
//        this.id = id;
//        this.title = title;
//        this.release_date = release_date;
//        this.overview = overview;
//        this.runtime = runtime;
//    }
//
//    public TMDBService getMovieDetail(@JsonProperty("id") Long id, @JsonProperty("title") String title,
//                                      @JsonProperty("release_date") String release_date, @JsonProperty("overview") String overview,
//                                      @JsonProperty("runtime") int runtime){
//        this.id = id;
//        this.title = title;
//        this.release_date = release_date;
//        this.overview = overview;
//        this.runtime = runtime;
//        return getMovieDetail(id, title, release_date, overview, runtime);
//    }
//
//    @JsonProperty("id")
//    private Long id;
//
//    @JsonProperty("title")
//    private String title;
//
//    @JsonProperty("release_date")
//    private String release_date;
//
//    @JsonProperty("overview")
//    private String overview;
//
//    @JsonProperty("runtime")
//    private int runtime;

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
