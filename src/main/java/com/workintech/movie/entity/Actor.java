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
@Table(name="actor", schema="fsweb")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="first_name")
    @NotNull
    private String firstName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name="birth_date")
    private LocalDate birthDate;

    @ManyToMany(cascade ={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name="movie_actor",schema="fsweb",joinColumns = @JoinColumn(name="actor_id"),inverseJoinColumns = @JoinColumn(name="movie_id"))
    List<Movie> movies;

    public void addMovie(Movie movie){
        if(movies==null){
            movies=new ArrayList<>();
        }
        movies.add(movie);
    }
}
