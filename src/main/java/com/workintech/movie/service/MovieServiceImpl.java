package com.workintech.movie.service;

import com.workintech.movie.dao.MovieDao;
import com.workintech.movie.entity.Movie;
import com.workintech.movie.exception.ApiException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService{

    private MovieDao movieDao;

    @Override
    public List<Movie> findAll() {
        return movieDao.findAll();
    }

    @Override
    public Movie findById(long id) {
        Optional<Movie> optionalMovie=movieDao.findById(id);
        if(optionalMovie.isPresent()){
            return optionalMovie.get();
        }
        throw new ApiException("Movie is not found with id: "+id, HttpStatus.NOT_FOUND);
    }

    @Override
    public Movie save(Movie movie) {
        return movieDao.save(movie);
    }

    @Override
    public Movie delete(long id) {
        Movie deleted=findById(id);
        movieDao.delete(deleted);
        return deleted;
    }
}
