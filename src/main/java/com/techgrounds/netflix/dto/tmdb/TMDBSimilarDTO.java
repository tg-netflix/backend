package com.techgrounds.netflix.dto.tmdb;

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

    private List<Map<String, Object>> results;


//    age certificate and runtime should be gotten from /movie/{id} endpoint
//    max 6 similar movies
    @Getter
    @Setter
    @NoArgsConstructor
    @Accessors(chain = true)
    static class TMDBSimilarResults {

    Map<String, Object> backdropMap;
    Map<String, Object> overviewMap;
    Map<String, Object> idMap;
    Map<String, Object> titleMap;
    Map<String, Object> releaseDateMap;

    private String backdrop_path;
    private String overview;
    private long id;
    private String title;
    //       private int runtime;
    private String release_date;
//       private String age_certificate;


//    public Map<String, Object> getBackdropMap() {
//        return (Map<String, Object>) backdropMap.put("backdrop_path", getBackdrop_path());
//    }
    public void getMaps(){
        getBackdropMap().put("backdrop_path", getBackdrop_path());
        getOverviewMap().put("description", getOverview());
        getIdMap().put("id", getId());
        getTitleMap().put("title", getTitle());
        getReleaseDateMap().put("release_date", getRelease_date());
    }
    }
}
