package com.techgrounds.netflix.dto.tmdb;

import com.techgrounds.netflix.dto.MovieDto;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
@Accessors(chain = true)
public class TMDBDiscover {
    public String page;
    public List<MovieDto> results;
}
