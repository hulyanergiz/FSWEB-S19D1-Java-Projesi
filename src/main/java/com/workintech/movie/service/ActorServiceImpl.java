package com.workintech.movie.service;

import com.workintech.movie.dao.ActorDao;
import com.workintech.movie.entity.Actor;
import com.workintech.movie.exception.ApiException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ActorServiceImpl implements ActorService{

    private ActorDao actorDao;

    @Override
    public List<Actor> finAll() {
        return actorDao.findAll();
    }

    @Override
    public Actor findById(long id) {
        Optional<Actor> optionalActor=actorDao.findById(id);
        if(optionalActor.isPresent()){
           return optionalActor.get();
        }
        throw new ApiException("Actor is not found with id: "+id, HttpStatus.NOT_FOUND);
    }

    @Override
    public Actor save(Actor actor) {
        return actorDao.save(actor);
    }

    @Override
    public Actor delete(long id) {
        Actor deleted=findById(id);
        actorDao.delete(deleted);
        return deleted;
    }
}
