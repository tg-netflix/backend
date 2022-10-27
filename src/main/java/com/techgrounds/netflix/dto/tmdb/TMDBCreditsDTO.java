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
public class TMDBCreditsDTO {
//    actors, writers and directors will be added from TMDB endpoint /movie/{id}/credits

    private List<TMDBCastDTO> cast;
    private List<TMDBCastDTO> crew;

    public List<String> getAllActors(){
        return getCast().stream()
                .filter(actor -> actor.getKnown_for_department().equalsIgnoreCase("Acting"))
                .map(TMDBCastDTO::getName)
                .limit(10)
                .toList();
    }

    public List<String> getAllWriters(){
        return getCrew().stream()
                .filter(writer -> writer.getKnown_for_department().equalsIgnoreCase("Writing")
                        && writer.getJob().equalsIgnoreCase("Screenplay"))
                .map(TMDBCastDTO::getName)
                .toList();
    }

    public List<String> getAllDirectors(){
        return getCrew().stream()
                .filter(director -> director.getKnown_for_department().equalsIgnoreCase("Directing")
                        && director.getJob().equalsIgnoreCase("Director"))
                .map(TMDBCastDTO::getName)
                .toList();
    }

    @Setter
    @Getter
    @ToString
    @NoArgsConstructor
    @Accessors(chain = true)
    static class TMDBCastDTO {

        private String name;
        private String known_for_department;
        private String job;

    }
}

