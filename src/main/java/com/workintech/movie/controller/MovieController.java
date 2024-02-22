package com.workintech.movie.controller;

import com.workintech.movie.dto.MovieRequest;
import com.workintech.movie.dto.MovieResponse;
import com.workintech.movie.entity.Actor;
import com.workintech.movie.entity.Movie;
import com.workintech.movie.service.MovieService;
import com.workintech.movie.util.MovieConverter;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;

    @GetMapping
    public List<MovieResponse> findAll(){
        List<Movie> movies=movieService.findAll();
        return MovieConverter.movieResponseConvert(movies);
    }

    @GetMapping("/{id}")
    public MovieResponse findById(@PathVariable long id){
        return MovieConverter.movieResponseConvert(movieService.findById(id));
    }

    @PostMapping
    public MovieResponse save(@RequestBody MovieRequest movieRequest){
        List<Actor> actors=movieRequest.getActors();
        Movie movie=movieRequest.getMovie();
        for(Actor actor:actors){
            movie.addActor(actor);
        }
        movieService.save(movie);
        return MovieConverter.movieResponseConvert(movie);
    }

    @PutMapping("/{id}")
    public MovieResponse update(@RequestBody Movie movie,@PathVariable long id){
        movieService.findById(id);
        movie.setActors(movie.getActors());
        movie.setId(id);
        movieService.save(movie);
        return MovieConverter.movieResponseConvert(movie);
    }
    @DeleteMapping("/{id}")
    public MovieResponse delete(@PathVariable long id){
        Movie deleted=movieService.findById(id);
        movieService.delete(id);
        return MovieConverter.movieResponseConvert(deleted);
    }
}
