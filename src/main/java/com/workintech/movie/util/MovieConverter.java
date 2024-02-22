package com.workintech.movie.util;

import com.workintech.movie.dto.MovieResponse;
import com.workintech.movie.entity.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieConverter {

    public static List<MovieResponse> movieResponseConvert(List<Movie> movies){
        List<MovieResponse> movieResponseList=new ArrayList<>();
        for(Movie movie:movies){
            movieResponseList.add(new MovieResponse(movie.getId(), movie.getName(),null));
        }
        return movieResponseList;
    }
    public static MovieResponse movieResponseConvert(Movie movie){
        return new MovieResponse(movie.getId(),movie.getName(),null);
    }
}
