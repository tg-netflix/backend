package com.techgrounds.netflix.dto.tmdb;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Accessors(chain = true)
public class TMDBSimilarDTO {
//    similar will be added from TMDB endpoint /movie/{id}/similar

//    age certificate and runtime should be gotten from /movie/{id} endpoint
//    max 6 similar movies

}
