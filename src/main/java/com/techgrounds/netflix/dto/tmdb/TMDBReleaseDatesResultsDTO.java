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
public class TMDBReleaseDatesResultsDTO {
//    age_certificate will be added from TMDB endpoint /movie/{id}/release_dates

    private List<TMDBAgeCertificateDTO> results;

    public String getAllResults(){
        return getResults().stream()
                .filter(certificate -> certificate.getIso_3166_1().equalsIgnoreCase("US"))
                .map(TMDBAgeCertificateDTO::getAllReleaseDates)
                .collect(Collectors.joining());
    }

    @Setter
    @Getter
    @ToString
    @NoArgsConstructor
    @Accessors(chain = true)
    static class TMDBAgeCertificateDTO {

        private String iso_3166_1;
        private List<TMDBCertificateReleaseDates> release_dates;

        public String getAllReleaseDates(){
            return getRelease_dates().stream()
                    .filter(list -> !list.getCertification().isEmpty())
                    .map(TMDBCertificateReleaseDates::getCertification)
                    .limit(1)
                    .collect(Collectors.joining());
        }
    }

    @Setter
    @Getter
    @ToString
    @NoArgsConstructor
    @Accessors(chain = true)
    static class TMDBCertificateReleaseDates {

        private String certification;

    }
}






