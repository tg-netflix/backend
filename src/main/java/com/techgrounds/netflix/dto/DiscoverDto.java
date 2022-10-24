package com.techgrounds.netflix.dto;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class DiscoverDto {
    public String page;
    public List<MovieDto> results;

    public DiscoverDto(DiscoverDto discoverMovie) {
    }
}
