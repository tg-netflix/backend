package com.techgrounds.netflix.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MockupMovie {
    private String id;
    private String original_title;
    private String overview;
    private String poster_path;
//    hierin staat welke json data de TMDB endpoint terug moet geven, zonder dat de data zelf mooier gemaakt is
}