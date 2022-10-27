package com.techgrounds.netflix.service;

import com.techgrounds.netflix.dto.Banner;
import com.techgrounds.netflix.dto.SimilarMovieDTO;
import com.techgrounds.netflix.dto.fanarttv.FanArtTVLogoDTO;
import com.techgrounds.netflix.dto.tmdb.*;
import com.techgrounds.netflix.response.MovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.techgrounds.netflix.dto.CategorieDto;
import com.techgrounds.netflix.dto.tmdb.TMDBDiscover;
import com.techgrounds.netflix.dto.tmdb.TMDBGenre;
import com.techgrounds.netflix.response.BrowseResponse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


@Service
public class NetflixService {
//    in this class the MovieResponse variables will be set

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
        movieResponse.setBackdrop_path(movie.getBackdrop_path())
                .setId(movie.getId())
                .setGenres(movie.getAllGenres())
                .setTitle(movie.getTitle())
                .setOverview(movie.getOverview())
                .setRelease_date(movie.getRelease_date())
                .setRuntime(movie.getRuntime());

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
            movieResponse.setLogo("https://i.chzbgr.com/full/9655877632/hD517A0BC/person-lokihee");
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
            List<SimilarMovieDTO> similarMovieList = similarMoviesList.getResults()
                    .stream()
                    .limit(6)
                    .map(similarMovie -> {
                        TMDBMovieDTO moreSimilarInfo = tmdbService.getMovie(similarMovie.getId(), apiKey);
                        similarMovie.setRuntime(moreSimilarInfo.getRuntime());

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
        if(banner){
            browseResponse.setBanner(getBannerInfo());
        }

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

        return browseResponse;
    }
    
    private Banner getBannerInfo() {
        CategorieDto categorieDto = new CategorieDto();
        categorieDto.setMovies(tmdbService.popularMovie(apiKey, 1).getResults());
        int min = 1;
        int max = categorieDto.getMovies().size();
        int randomNumber = ThreadLocalRandom.current().nextInt(min,max + 1);
        Long randomMovieId = (long) Integer.parseInt(categorieDto.getMovies().get(randomNumber).getId());

        Banner banner = new Banner();
        MovieResponse movieResponse = getSingleMovie(randomMovieId, false);
        try {
            FanArtTVLogoDTO fanArtTVLogoDTO = fanArtTVService.getMovieLogo(randomMovieId, fanApiKey);
            banner.setLogo(fanArtTVLogoDTO.getFirstLogo());
        }catch (Exception e){
            banner.setLogo("https://i.chzbgr.com/full/9655877632/hD517A0BC/person-lokihee");
        }
        banner.setId(movieResponse.getId());
        banner.setTrailer(movieResponse.getTrailer());
        banner.setTitle(movieResponse.getTitle());
        banner.setOverview(movieResponse.getOverview());
        banner.setAge_certificate(movieResponse.getAge_certificate());
        banner.setBackdrop_path(movieResponse.getBackdrop_path());

        return banner;
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

