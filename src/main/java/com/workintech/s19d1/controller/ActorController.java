package com.workintech.s19d1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workintech.s19d1.dto.ActorDto;
import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.service.ActorService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(path = "/actors")
public class ActorController {

    private ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public List<Actor> findAll() {
        return actorService.findAll();
    }

    @GetMapping(path = "/{id}")
    public ActorDto findById(@PathVariable("id") Long id) {
        Actor actor = actorService.findById(id);
        return new ActorDto(actor.getId(), actor.getFirstName(), actor.getLastName());
    };

    @PostMapping
    public ActorDto save(@RequestBody Actor actor) {
        Actor actorSaved = actorService.save(actor);

        return new ActorDto(actorSaved.getId(), actorSaved.getFirstName(), actorSaved.getLastName());
    }

    @DeleteMapping(path = "/{id}")
    public ActorDto delete(@PathVariable("id") Long id) {
        Actor removedActor = actorService.delete(id);
        return new ActorDto(removedActor.getId(), removedActor.getFirstName(), removedActor.getLastName());
    }

    @PostMapping(path = "/{id}")
    public ActorDto update(@PathVariable("id") Long id, @RequestBody Actor actor) {
        Actor updatedActor = actorService.update(id, actor);
        return new ActorDto(updatedActor.getId(), updatedActor.getFirstName(), updatedActor.getLastName());
    }

    @PostMapping(path = "/{actorId}/{movieId}")
    public Actor addMovie(@PathVariable("actorId") Long actorId, @PathVariable("movieId") Integer movieId) {
        return actorService.addMovie(actorId, movieId);

    }

}
