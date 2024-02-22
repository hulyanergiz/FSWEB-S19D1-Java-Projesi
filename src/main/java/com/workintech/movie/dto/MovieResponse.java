package com.workintech.movie.dto;

import com.workintech.movie.entity.Actor;

import java.util.List;

public record MovieResponse(long id, String name, List<Actor> actors) {
}
