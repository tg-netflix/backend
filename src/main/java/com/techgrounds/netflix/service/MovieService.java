package com.techgrounds.netflix.service;

import com.techgrounds.netflix.response.SimilarMovieResponse;
import com.techgrounds.netflix.dto.fanarttv.FanArtTVLogoDTO;
import com.techgrounds.netflix.dto.tmdb.*;
import com.techgrounds.netflix.response.MovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovieService {
//    in this class the MovieResponse and SimilarMovieResponse variables will be set

    @Value("${apiKey}")
    private String apiKey;

    @Value("${fanApiKey}")
    private String fanApiKey;

    @Autowired
    private TMDBService tmdbService;

    @Autowired
    private FanArtTVService fanArtTVService;


//    method to call in controller for getting al details of a single movie
    public MovieResponse getSingleMovie(Long id, boolean similar){
        MovieResponse movieResponse = new MovieResponse();

//        set basic movie information like id, title, description, release_date, runtime and genres
        TMDBMovieDTO movie = tmdbService.getMovie(id, apiKey);
        movieResponse.setId(movie.getId())
                .setGenres(movie.getAllGenres())
                .setTitle(movie.getTitle())
                .setOverview(movie.getOverview())
                .setRelease_date(movie.getRelease_date())
                .setRuntime(movie.getRuntime());

//        set backdrop
        if (movie.getBackdrop_path() != null){
            movieResponse.setBackdrop_path("https://image.tmdb.org/t/p/original" + movie.getBackdrop_path());
        }
        else {
            movieResponse.setBackdrop_path("https://images3.alphacoders.com/678/678085.jpg");
        }

//        set poster
        if (movie.getPoster_path() != null) {
            movieResponse.setPoster_path("https://image.tmdb.org/t/p/w500" + movie.getPoster_path());
        }
        else {
            movieResponse.setPoster_path("https://i.chzbgr.com/full/9655877632/hD517A0BC/person-lokihee");
        }

//        set trailer
        TMDBVideoDTO videos = tmdbService.getVideos(id, apiKey);
        movieResponse.setTrailer(videos.getTrailerResult());

//        set logo
        try {
            FanArtTVLogoDTO movieLogos = fanArtTVService.getMovieLogo(id, fanApiKey);
            movieResponse.setLogo(movieLogos.getFirstLogo());
        }
        catch(Exception e) {
            e.printStackTrace();
            movieResponse.setLogo("https://png.pngtree.com/png-clipart/20191111/ourmid/pngtree-3d-oops-png-black-and-gold-glossy-typography.jpg");
        }

//        set keywords
        TMDBKeywordsDTO movieKeywords = tmdbService.getKeywords(id, apiKey);
        movieResponse.setKeywords(movieKeywords.getListOfKeywords());

//        set age_certificate
        TMDBReleaseDatesResultsDTO movieCertification = tmdbService.getCertification(id, apiKey);
        movieResponse.setAge_certificate(movieCertification.getAllResults());

//        set actors, writers and directors
        TMDBCreditsDTO movieCredits = tmdbService.getCredits(id, apiKey);
        movieResponse.setActors(movieCredits.getAllActors());
        movieResponse.setWriters(movieCredits.getAllWriters());
        movieResponse.setDirectors(movieCredits.getAllDirectors());


//        set similar, only if boolean similar = true
        if(similar) {
            TMDBSimilarDTO similarMoviesList = tmdbService.getSimilarMovies(id, apiKey);
            List<SimilarMovieResponse> similarMovieList = similarMoviesList.getResults()
                    .stream()
                    .limit(6)
                    .map(similarMovie -> {
                        TMDBMovieDTO moreSimilarInfo = tmdbService.getMovie(similarMovie.getId(), apiKey);
                        similarMovie.setRuntime(moreSimilarInfo.getRuntime())
                                .setBackdrop_path("https://image.tmdb.org/t/p/original" + moreSimilarInfo.getBackdrop_path());

                        TMDBReleaseDatesResultsDTO similarMovieCertification = tmdbService.getCertification(similarMovie.getId(), apiKey);
                        similarMovie.setAge_certificate(similarMovieCertification.getAllResults());
                        return similarMovie;
                    })
                    .toList();
            movieResponse.setSimilar(similarMovieList);
        }

//        return movieResponse with all set variables
        return movieResponse;
    }
}

