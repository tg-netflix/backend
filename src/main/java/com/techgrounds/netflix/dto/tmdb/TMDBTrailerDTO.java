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
public class TMDBTrailerDTO {

    private String key;
    private String site;
    private String type;
    private boolean official;

//    key = trailer id for youtube
//    site = YouTube
//    type = trailer/clip/teaser. Only trailer is needed
//    official is from official youtube channel or not
}
