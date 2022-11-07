package com.techgrounds.netflix.dto;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Data
@Accessors(chain = true)
public class CategorieDto {
    private String page;
    private String name;
    private List<MovieDto> movies;

}
