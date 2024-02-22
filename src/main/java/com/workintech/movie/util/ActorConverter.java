package com.workintech.movie.util;

import com.workintech.movie.dto.ActorResponse;
import com.workintech.movie.entity.Actor;

import java.util.ArrayList;
import java.util.List;

public class ActorConverter {

    public static List<ActorResponse> actorResponseConvert(List<Actor> actors){
        List<ActorResponse> actorResponseList=new ArrayList<>();
        for(Actor actor:actors){
            actorResponseList.add(new ActorResponse(actor.getId(), actor.getFirstName(),actor.getBirthDate(),null));
        }
        return actorResponseList;
    }
    public static ActorResponse actorResponseConvert(Actor actor){
        return new ActorResponse(actor.getId(),actor.getFirstName(),actor.getBirthDate(),null);
    }
}
