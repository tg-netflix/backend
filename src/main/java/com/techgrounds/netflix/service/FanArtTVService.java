package com.techgrounds.netflix.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import com.techgrounds.netflix.dto.fanarttv.FanArtTVLogoDTO;

@FeignClient(name="fanarttv", url="https://webservice.fanart.tv/v3")
public interface FanArtTVService {
//    in this interface endpoints from FanArtTV will be called to use the FanArtTV data in our own endpoints

    @GetMapping("/movies/{id}")
    FanArtTVLogoDTO getMovieLogo(@PathVariable Long id, @RequestParam("api_key") String fanApiKey);

}
