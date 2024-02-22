package com.workintech.movie.service;

import com.workintech.movie.entity.Actor;

import java.util.List;

public interface ActorService {
    List<Actor> finAll();

    Actor findById(long id);

    Actor save(Actor actor);

    Actor delete(long id);
}
