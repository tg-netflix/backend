package com.techgrounds.netflix.entity;

import com.techgrounds.netflix.dto.SimilarMovieDTO;
import com.techgrounds.netflix.dto.tmdb.TMDBSimilarDTO;
import lombok.AllArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
@AllArgsConstructor
public class TMDBSimilarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long Id;
    public List<SimilarMovieEntity> results;

    public static TMDBSimilarEntity fromSimilarDTO(long id, TMDBSimilarDTO original) {
        return new TMDBSimilarEntity(
                id,
                original.getResults().stream()
                        .map(SimilarMovieEntity::fromSimilarMovieDTO)
                        .toList()
        );
    }
}
