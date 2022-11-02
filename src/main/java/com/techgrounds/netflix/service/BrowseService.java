package com.techgrounds.netflix.service;

import com.techgrounds.netflix.dto.Banner;
import com.techgrounds.netflix.dto.fanarttv.FanArtTVLogoDTO;
import com.techgrounds.netflix.response.MovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import com.techgrounds.netflix.dto.CategorieDto;
import com.techgrounds.netflix.dto.tmdb.TMDBDiscover;
import com.techgrounds.netflix.dto.tmdb.TMDBGenre;
import com.techgrounds.netflix.response.BrowseResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class BrowseService {

    @Value("${apiKey}")
    private String apiKey;

    @Value("${fanApiKey}")
    private String fanApiKey;

    @Autowired
    private TMDBService tmdbService;

    @Autowired
    private FanArtTVService fanArtTVService;

    @Autowired
    private MovieService movieService;

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
        MovieResponse movieResponse = movieService.getSingleMovie(randomMovieId, false);
        try {
            FanArtTVLogoDTO fanArtTVLogoDTO = fanArtTVService.getMovieLogo(randomMovieId, fanApiKey);
            banner.setLogo(fanArtTVLogoDTO.getFirstLogo());
        }catch (Exception e){
            banner.setLogo("https://png.pngtree.com/png-clipart/20191111/ourmid/pngtree-3d-oops-png-black-and-gold-glossy-typography.jpg");
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