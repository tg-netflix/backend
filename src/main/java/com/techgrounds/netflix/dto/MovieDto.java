package com.techgrounds.netflix.dto;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    public void setBackdrop_path(String backdrop_path) {
        if(backdrop_path == null){
            this.backdrop_path = "https://images3.alphacoders.com/678/678085.jpg";
        }else {
            this.backdrop_path = "https://image.tmdb.org/t/p/original" + backdrop_path;
        }
    }

    private String backdrop_path;
    private String id;
    private String title;
}
