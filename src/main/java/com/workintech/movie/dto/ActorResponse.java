package com.workintech.movie.dto;

import com.workintech.movie.entity.Movie;

import java.time.LocalDate;
import java.util.List;

public record ActorResponse(long id, String firstName,LocalDate birthDate, List<Movie> movies) {
}
