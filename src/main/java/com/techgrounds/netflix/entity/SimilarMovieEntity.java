package com.techgrounds.netflix.entity;

import com.techgrounds.netflix.dto.SimilarMovieDTO;
import lombok.AllArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@AllArgsConstructor
@Entity
public class SimilarMovieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String backdrop_path;
    private String overview;

    private String title;
    private int runtime;
    private String release_date;
    private String age_certificate;

    public static SimilarMovieEntity fromSimilarMovieDTO(SimilarMovieDTO original) {
        return new SimilarMovieEntity(
            original.getId(),
            original.getBackdrop_path(),
            original.getOverview(),
            original.getTitle(),
            original.getRuntime(),
            original.getRelease_date(),
            original.getAge_certificate()
        );
    }
}
