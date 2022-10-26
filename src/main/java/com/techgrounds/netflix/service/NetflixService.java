package com.techgrounds.netflix.service;

import com.techgrounds.netflix.dto.tmdb.*;
import com.techgrounds.netflix.response.MovieResponse;
import com.techgrounds.netflix.response.SimilarMovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.techgrounds.netflix.dto.CategorieDto;
import com.techgrounds.netflix.dto.tmdb.TMDBDiscover;
import com.techgrounds.netflix.dto.tmdb.TMDBGenre;
import com.techgrounds.netflix.model.MockupMovie;
import com.techgrounds.netflix.response.BrowseResponse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;


@Service
public class NetflixService {
//    in this class the MovieResponse variables will be set

    @Value("${apiKey}")
    private String apiKey;

    @Autowired
    private TMDBService tmdbService;


//    method to call in controller for getting al details of a single movie
    public MovieResponse getSingleMovie(Long id, boolean details, boolean similar){
        MovieResponse movieResponse = new MovieResponse();

//        set basic movie information like id, title, description, release_date, runtime and genres
        TMDBMovieDTO movie = tmdbService.getMovie(id, apiKey);
        movieResponse.setId(movie.getId())
                .setGenres(movie.getAllGenres())
                .setTitle(movie.getTitle())
                .setDescription(movie.getOverview())
                .setRelease_date(movie.getRelease_date())
                .setRuntime(movie.getRuntime());

//        set trailer
        TMDBVideoDTO videos = tmdbService.getVideos(id, apiKey);
        movieResponse.setTrailer(videos.getTrailerResult());

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


//        TMDBSimilarDTO similarMoviesList = tmdbService.getSimilarMovies(id, apiKey);
//        SimilarMovieResponse similarMovieResponse = new SimilarMovieResponse();
//        similarMovieResponse.setBackdrop_path(similarMoviesList.getBackdrop_path())
//                .setDescription(similarMoviesList.getOverview())
//                .setId(similarMoviesList.getId())
//                .setTitle(similarMoviesList.getTitle())
//                .setRelease_date(similarMoviesList.getRelease_date());
//        movieResponse.setSimilar(similarMovieResponse);

//        Only get similar movies if similar parameter is true:
//        if(similar == true) {
//            movieResponse.setSimilar();
//        }

//        return movieResponse with all set variables
        return movieResponse;
    }

    public SimilarMovieResponse getSimilarMovies(Long id, boolean details, boolean similar){
        SimilarMovieResponse similarMovieResponse = new SimilarMovieResponse();
        TMDBSimilarDTO similarMoviesList = tmdbService.getSimilarMovies(id, apiKey);



        return similarMovieResponse;
    }
//     
// 
// 
// Start Hiu-Chee /browse code
// 
// 
// 
public BrowseResponse getBrowseMovies(String categories, boolean banner, int page) {
        BrowseResponse browseResponse = new BrowseResponse();
        // banner
//        if(banner){
//            browseResponse.setBanner(getBannerInfo());
//        }

        //list of categories
        List<CategorieDto> newCateList = new ArrayList<>();

        String[] paramCate = categories.split(",");

        for (var eachCate: paramCate) {
            LocalDate today = LocalDate.now();
            int defaultYear = today.getYear();
//            try{
                List<TMDBGenre> newGenreList = tmdbService.getGenresList(apiKey).getGenreList();

                TMDBGenre findGenre = newGenreList.stream()
                    .filter(tmdbGenre -> eachCate.equalsIgnoreCase(tmdbGenre.getName()))
                    .findAny()
                    .orElse(null);
                if(findGenre == null){
                    switch(eachCate) {
                        case "popular":
                            newCateList.add(getPopularMovie(eachCate, page));
                            break;
                        case "top_rated":
                            newCateList.add(getTopRatedMovie(eachCate, page));
                            break;
                        case "latest":
                            newCateList.add(getMovies(eachCate,"release_date.desc",today.toString(), "", defaultYear, page));
                            break;
                        case "disney":
                            newCateList.add(getMovies(eachCate,"",today.toString(),"2", defaultYear, page));
                            break;
                        case "classic":
                            int min = 1980;
                            int max = 1999;
                            defaultYear = ThreadLocalRandom.current().nextInt(min,max + 1);;
                            newCateList.add(getMovies(eachCate,"",today.toString(), "", defaultYear, page));
                            break;
                        default:
                            System.out.println(eachCate + " : do not exist");
                            break;
                    }
                }else{
                    newCateList.add(getMovies(findGenre.getName(),"",today.toString(),  "", defaultYear, page));
                }
//            }
//            catch (Exception e){
//                System.out.println(eachCate + " : do not exist");
//            }
        }

        browseResponse.setCategories(newCateList);

//        hier spreek TMDB service aan
//        en zet resultaat daarvan om naar BrowseResponse
        return browseResponse;
    }
    
    private MockupMovie getBannerInfo() {
        CategorieDto categorieDto = new CategorieDto();
        categorieDto.setMovies(tmdbService.popularMovie(apiKey, 1).getResults());
        int min = 1;
        int max = categorieDto.getMovies().size();
        int randomNumber = ThreadLocalRandom.current().nextInt(min,max + 1);
        Long randomMovieId = Long.valueOf(Integer.parseInt(categorieDto.getMovies().get(randomNumber).getId()));

        // System.out.println(randomMovieId);
        // MockupMovie mockupMovie = tmdbService.getMovie(randomMovieId, apiKey);
        // return mockupMovie;
        return null;

    }

    public CategorieDto getPopularMovie(String genreName, int page){
        TMDBDiscover tmdbDiscover = tmdbService.popularMovie(apiKey, page);
        CategorieDto categorieDto = new CategorieDto();
        categorieDto.setMovies(tmdbDiscover.getResults());
        categorieDto.setPage(tmdbDiscover.getPage());
        categorieDto.setName(genreName);
        return categorieDto;
    }
    public CategorieDto getTopRatedMovie(String genreName, int page){
        TMDBDiscover tmdbDiscover = tmdbService.topRatedMovie(apiKey, page);
        CategorieDto categorieDto = new CategorieDto();
        categorieDto.setMovies(tmdbDiscover.getResults());
        categorieDto.setPage(tmdbDiscover.getPage());
        categorieDto.setName(genreName);
        return categorieDto;
    }
    public CategorieDto getMovies(String genreName, String sortBy, String dateToday, String with_company, int yearRand, int page){
        TMDBDiscover tmdbDiscover = tmdbService.movieNonGenre(apiKey, genreName, sortBy, dateToday, with_company, yearRand, page);
        CategorieDto categorieDto = new CategorieDto();
        categorieDto.setMovies(tmdbDiscover.getResults());
        categorieDto.setPage(tmdbDiscover.getPage());
        categorieDto.setName(genreName);
        return categorieDto;
    }
}

