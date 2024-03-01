package com.workintech.s19d1.service;

import java.util.List;

import com.workintech.s19d1.entity.Actor;

public interface ActorService {
    List<Actor> findAll();

    Actor findById(Long id);

    Actor update(Long id, Actor actor);

    Actor save(Actor actor);

    Actor delete(Long id);

    Actor addMovie(Long actorId, Integer movieId);

}
