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
public class TMDBAgeCertificateDTO {
//    Get certificate from TMDB endpoint /movie/{movie_id}/release_dates
//    ONLY use certification from "iso_3166_1": "US"
}
