package com.workintech.s19d1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.repository.ActorRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;
    private final MovieService movieService;

    @Override
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Override
    public Actor findById(Long id) {
        @SuppressWarnings("null")
        Optional<Actor> actorOptional = actorRepository.findById(id);
        return actorOptional.orElseThrow();
        // TODO error handling
    }

    @Override
    public Actor update(Long id, Actor actor) {

        Actor existingActor = findById(id);

        existingActor.setBirthDate(actor.getBirthDate());
        existingActor.setFirstName(actor.getFirstName());
        existingActor.setGender(actor.getGender());
        existingActor.setLastName(actor.getLastName());
        existingActor.setMovies(actor.getMovies());

        return actorRepository.save(existingActor);
    }

    @SuppressWarnings("null")
    @Override
    public Actor save(Actor actor) {
        return actorRepository.save(actor);
    }

    @SuppressWarnings("null")
    @Override
    public Actor delete(Long id) {
        Actor existActor = findById(id);
        actorRepository.delete(existActor);
        return existActor;
    }

    @Override
    public Actor addMovie(Long actorId, Integer movieId) {
        Actor existingActor = findById(actorId);
        Movie existingMovie = movieService.findById(movieId);

        existingActor.addMovie(existingMovie);

        return update(actorId, existingActor);
    }

}
