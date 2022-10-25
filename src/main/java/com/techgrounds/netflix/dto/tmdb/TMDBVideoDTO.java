package com.techgrounds.netflix.dto.tmdb;

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
public class TMDBVideoDTO {

    private List<TMDBTrailerDTO> results;

//    Add trailer by using TMDB endpoint /movie/{movie_id}/videos
//    https://www.youtube.com/watch?v=BdJKm16Co6M
//    endpoint will look like /watch and @requestparam for trailer key
//    "official": true. Only use official trailers
}
