package com.techgrounds.netflix.service;

import com.techgrounds.netflix.dto.FanArtTVLogoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="fanarttv", url="http://webservice.fanart.tv/v3")
public interface FanArtTVService {

    @GetMapping("/movies/{id}")
    FanArtTVLogoDTO getLogo(@PathVariable Long id, @RequestParam("api_key") String fanApiKey);

}
