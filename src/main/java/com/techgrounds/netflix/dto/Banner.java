package com.techgrounds.netflix.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Banner {
        private String backdrop_path;
        private String overview;
        private Long id;
        private String logo;//
        private String title;
        private String trailer;
        private String age_certificate;
}
