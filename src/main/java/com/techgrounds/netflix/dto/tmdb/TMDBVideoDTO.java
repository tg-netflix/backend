package com.techgrounds.netflix.dto.tmdb;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Accessors(chain = true)
public class TMDBVideoDTO {
//        trailer will be added from TMDB endpoint /movie/{id}/videos

    private List<TMDBTrailerDTO> results;

    public String getTrailerResult(){
        return getResults().stream()
                .filter(trailer -> trailer.getType().equalsIgnoreCase("Trailer")
                        && trailer.getSite().equalsIgnoreCase("YouTube") && trailer.isOfficial())
                .map(TMDBTrailerDTO::getKey)
                .limit(1)
                .collect(Collectors.joining());
    }

    @Setter
    @Getter
    @ToString
    @NoArgsConstructor
    @Accessors(chain = true)
    static class TMDBTrailerDTO {

        private String key;
        private String site;
        private String type;
        private boolean official;

    }
}
