package com.techgrounds.netflix.dto.tmdb;

import com.techgrounds.netflix.dto.SimilarMovieDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Accessors(chain = true)
public class TMDBSimilarDTO {
//    similar will be added from TMDB endpoint /movie/{id}/similar
//    gets list of variables determined in SimilarMovieDTO

    private List<SimilarMovieDTO> results;

}
