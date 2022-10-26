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
public class TMDBKeywordsDTO {
//    keywords will be added from TMDB endpoint /movie/{id}/keywords

    private List<TMDBKeywordNameDTO> keywords;

    public List<String> getListOfKeywords(){
        return getKeywords().stream()
                .map(TMDBKeywordNameDTO::getName)
                .limit(3)
                .toList();
    }

    @Setter
    @Getter
    @ToString
    @NoArgsConstructor
    @Accessors(chain = true)
    static class TMDBKeywordNameDTO {

        private String name;

    }
}
