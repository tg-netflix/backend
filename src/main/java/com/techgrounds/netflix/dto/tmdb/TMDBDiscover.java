package com.techgrounds.netflix.dto.tmdb;

import com.techgrounds.netflix.dto.MovieDto;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class TMDBDiscover {
    public String page;
    public List<MovieDto> results;
}
