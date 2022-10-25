package com.techgrounds.netflix.service;

import com.techgrounds.netflix.dto.tmdb.TMDBDiscover;
import com.techgrounds.netflix.response.BrowseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.time.LocalDate;

@Service
public class MovieService {

    @Value("${apiKey}")
    private String apiKey;

    @Autowired
    private TMDBService tmdbService;

    public BrowseResponse getBrowseMovies(String categories, boolean banner, int page) {
        String[] newCategories = categories.split(",");
        System.out.println(newCategories.length);
        System.out.println(banner);
        System.out.println(page);

        LocalDate localDate = LocalDate.now();

        TMDBDiscover tmdbDiscover = tmdbService.latestMovie(apiKey, "release_date.desc", localDate.toString());
        BrowseResponse browseResponse = new BrowseResponse();
        browseResponse.setMovies(tmdbDiscover.getResults());
        browseResponse.setPage(tmdbDiscover.getPage());
        browseResponse.setName("Lates");

//        hier spreek TMDB service aan
//        en zet resultaat daarvan om naar BrowseResponse
        return browseResponse;
    }

//    public MovieResponse getSingleMovie() {
//
//    }
}
