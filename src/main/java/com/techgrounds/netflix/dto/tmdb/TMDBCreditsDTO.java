package com.techgrounds.netflix.dto.tmdb;

import com.techgrounds.netflix.dto.tmdb.TMDBCastDTO;
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
public class TMDBCreditsDTO {

    private List<TMDBCastDTO> cast;
    private List<TMDBCastDTO> crew;

//    Add names of cast from TMDB endpoint /movie/{movie_id}/credits Only names.
//    cast is a list. Add only names from that array, but max 10 actors, 10 writers and 10 directors
//    make sure to filter the names on known_for_department
}
