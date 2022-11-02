package com.techgrounds.netflix.dto;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CategorieDto {
    private String page;
    private String name;
    private List<MovieDto> movies;

}
