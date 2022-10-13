package com.techgrounds.netflix.DTO;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MockupMovieDto {
    private String id;
    private String original_title;
    private String overview;
    private String poster_path;
}