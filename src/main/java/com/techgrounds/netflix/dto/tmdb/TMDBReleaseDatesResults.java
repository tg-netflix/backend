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
public class TMDBReleaseDatesResults {

    private List<TMDBAgeCertificateDTO> results;
}
