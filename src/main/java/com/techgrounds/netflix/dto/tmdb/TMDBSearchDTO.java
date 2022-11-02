package com.techgrounds.netflix.dto.tmdb;

import com.techgrounds.netflix.response.MovieResponse;
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
public class TMDBSearchDTO {

    private List<MovieResponse> results;

}
