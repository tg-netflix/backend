package com.techgrounds.netflix.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class SimilarMovieResponse {
//    this class will contain all variables that should be received in the similar list

    private String backdrop_path;
    private String description;
    private long id;
    private String title;
    //       private int runtime;
    private String release_date;
//       private String age_certificate;

}
