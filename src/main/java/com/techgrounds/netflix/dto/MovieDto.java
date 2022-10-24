package com.techgrounds.netflix.dto;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    private String backdrop_path;
    private String id;
    private String title;
}
