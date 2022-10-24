package com.techgrounds.netflix.service;
<<<<<<< HEAD

=======
//import com.techgrounds.netflix.dto.TMDBMovieResult;
>>>>>>> 2df62c689bea06449fb99398611a1fa602385f95
import com.techgrounds.netflix.dto.tmdb.TMDBDiscover;
import com.techgrounds.netflix.model.MockupMovie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

<<<<<<< HEAD

=======
>>>>>>> 2df62c689bea06449fb99398611a1fa602385f95
@FeignClient(name="tmdb", url="https://api.themoviedb.org/3")
public interface TMDBService {
    @GetMapping(value = "/discover/movie", produces = "application/json")
    TMDBDiscover discoverMovie(@RequestParam("api_key") String apiKey);

    @GetMapping(value = "/movie/popular", produces = "application/json")
    List<MockupMovie> popularMovie(@RequestParam("api_key") String apiKey);

    @RequestMapping(method = RequestMethod.GET, value = "/movie/{id}", produces = "application/json")
    MockupMovie getMovie(@PathVariable Long id, @RequestParam("api_key") String apiKey);

    @GetMapping(value = "/movie/{id}/videos", produces = "application/json")
    String getMovieVideos(@PathVariable Long id, @RequestParam("api_key") String apiKey);
}