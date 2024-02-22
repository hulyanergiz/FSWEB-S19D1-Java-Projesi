package com.workintech.movie.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="movie",schema="fsweb")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Movie name cannot be null")
    private String name;

    @Column(name="director_name")
    @NotNull(message="Director name cannot be null")
    private String directorName;

    private Integer rating;

    @Column(name="release_date")
    private LocalDate releaseDate;

    @ManyToMany(cascade ={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name="movie_actor",schema="fsweb",joinColumns = @JoinColumn(name="movie_id"),inverseJoinColumns = @JoinColumn(name="actor_id"))
    List<Actor> actors;

    public void addActor(Actor actor){
        if(actors==null){
            actors=new ArrayList<>();
        }
        actors.add(actor);
    }

}
