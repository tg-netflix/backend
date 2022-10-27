package com.techgrounds.netflix.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class BrowseResponse {
    private Object banner;
    private List<?> categories;
}
