package com.techgrounds.netflix.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NetflixService {
    @Value("${apiKey}")
    private String apiKey;

    public String getSingleMovie(Long id){
        return "hello";
    }
//    hier de MockupMovie data mooier maken zodat het teruggegeven wordt zoals de frontend dat wil
}
