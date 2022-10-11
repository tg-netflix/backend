package com.techgrounds.netflix.controller;

import com.techgrounds.netflix.model.Movie;
import com.techgrounds.netflix.service.TMDBService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Iterator;

@RestController
public class DemoController {

    @Value("${apiKey}")
    private String apiKey;

    @Autowired
    private TMDBService tmdbService;

    @GetMapping("/")
    public String getData(){
        return apiKey;
    }

    @GetMapping("/movie")
    public String getDiscoverMovie(){
        return tmdbService.discoverMovie(apiKey);
    }

    @GetMapping("/movie/{id}")
    public String getMovieDetails(@PathVariable Long id){
        return tmdbService.getMovie(id, apiKey);
    }


    @GetMapping("/movie/{id}/videos")
    public String getMovieVideos(@PathVariable Long id){
        return tmdbService.getMovie(id, apiKey);
    }
    @GetMapping("/movie/popular")
    public String getPopularMovie(){
        return test(tmdbService.popularMovie(apiKey));
//        return tmdbService.popularMovie(apiKey);
    }
    public String test(String str){
        try {
            if (str != null) {

                JSONObject jsonObject = new JSONObject(str);
                JSONArray jsonArray = jsonObject.getJSONArray("results");

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                    var movie = new Movie();
                    movie.setId(jsonObject1.getInt("id"));
                    movie.setOverview(jsonObject1.getString("overview"));
                    movie.setOriginal_title(jsonObject1.getString("original_title"));
                    movie.setPoster_path(jsonObject1.getString("poster_path"));
//                    System.out.print(movie.getId() + " : ");
//                    System.out.println(movie.getOriginal_title());
                }
//                JSONObject items = new JSONObject(ret);
//                Iterator x = items.keys();
//                JSONArray jsonArray = new JSONArray();
//
//                while (x.hasNext()) {
//                    String key = (String) x.next();
//                    jsonArray.put(items.get(key));
//                    System.out.println(key + " : " + items.get(key));
//                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
