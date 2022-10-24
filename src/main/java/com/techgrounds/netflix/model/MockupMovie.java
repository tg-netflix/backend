package com.techgrounds.netflix.model;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MockupMovie {
    private String id;
    private String original_title;
    private String overview;
    private String poster_path;
}