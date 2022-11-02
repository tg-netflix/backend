package com.techgrounds.netflix.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class SearchedMoviesResponse {

    private String backdrop_path;
    private long id;
    private String title;

}
