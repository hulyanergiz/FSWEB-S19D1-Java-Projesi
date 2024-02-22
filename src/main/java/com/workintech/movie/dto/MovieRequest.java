package com.workintech.movie.dto;

import com.workintech.movie.entity.Actor;
import com.workintech.movie.entity.Movie;
import lombok.Data;

import java.util.List;

@Data
public class MovieRequest {

    private List<Actor> actors;

    private Movie movie;
}
