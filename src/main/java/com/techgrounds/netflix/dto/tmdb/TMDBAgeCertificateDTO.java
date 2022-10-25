package com.techgrounds.netflix.dto.tmdb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Accessors(chain = true)
public class TMDBAgeCertificateDTO {

    private String iso_3166_1;
    private List<TMDBCertificateReleaseDates> release_dates;

//    private String iso_3166_1;
//    private String release_dates_certification;
//
//    @SuppressWarnings("unchecked")
//    @JsonProperty("results")
//    private void unpackNested(Map<String, Object> results) {
//        this.iso_3166_1 = (String)results.get("iso_3166_1");
//        Map<String,String> release_dates = (Map<String,String>)results.get("release_dates");
//        this.release_dates_certification = release_dates.get("certification");
//    }

    //    Get certificate from TMDB endpoint /movie/{movie_id}/release_dates
//    ONLY use certification from "iso_3166_1": "US"
}
