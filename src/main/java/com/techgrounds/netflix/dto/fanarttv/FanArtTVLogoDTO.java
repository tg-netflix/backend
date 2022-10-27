package com.techgrounds.netflix.dto.fanarttv;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class FanArtTVLogoDTO {
//    logo url will be added from FanartTV endpoint /movies/{id}

    private List<FanArtTVLogoURL> movieposter;

    public String getFirstLogo(){
        return getMovieposter().stream()
                .map(FanArtTVLogoURL::getUrl)
                .limit(1)
                .collect(Collectors.joining());
    }

    @Setter
    @Getter
    @ToString
    @NoArgsConstructor
    @Accessors(chain = true)
    static class FanArtTVLogoURL {

        private String url;

    }
}
