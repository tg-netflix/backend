package com.techgrounds.netflix.dto.tmdb;

import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class TMDBDiscover {
    public String page;
    public List<TMDBMovie> results;
}
