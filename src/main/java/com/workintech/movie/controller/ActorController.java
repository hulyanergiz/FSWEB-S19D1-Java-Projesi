package com.workintech.movie.controller;

import com.workintech.movie.dto.ActorRequest;
import com.workintech.movie.dto.ActorResponse;
import com.workintech.movie.entity.Actor;
import com.workintech.movie.entity.Movie;
import com.workintech.movie.service.ActorService;
import com.workintech.movie.util.ActorConverter;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/actors")
public class ActorController {

    private ActorService actorService;

    @GetMapping
    public List<ActorResponse> findAll(){
        List<Actor> actors=actorService.finAll();
        return ActorConverter.actorResponseConvert(actors);
    }

    @GetMapping("/{id}")
    public ActorResponse findById(@PathVariable long id){
        return ActorConverter.actorResponseConvert(actorService.findById(id));
    }

    @PostMapping
    public ActorResponse save(@RequestBody ActorRequest actorRequest){
        List<Movie> movies=actorRequest.getMovies();
        Actor actor=actorRequest.getActor();
        for(Movie movie:movies){
            actor.addMovie(movie);
        }
        actorService.save(actor);
        return ActorConverter.actorResponseConvert(actor);
    }

    @PutMapping("/{id}")
    public ActorResponse update(@RequestBody Actor actor,@PathVariable long id){
        actorService.findById(id);
        actor.setMovies(actor.getMovies());
        actor.setId(id);
        actorService.save(actor);

        return ActorConverter.actorResponseConvert(actor);
    }

    @DeleteMapping("/{id}")
    public ActorResponse delete(@PathVariable long id){
        Actor deleted=actorService.findById(id);
        actorService.delete(id);
        return ActorConverter.actorResponseConvert(deleted);
    }

}
