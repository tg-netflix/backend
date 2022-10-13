package com.techgrounds.netflix.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Genre {
    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;
}
