package com.workintech.s19d1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.repository.MovieRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie findById(int id) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isPresent()) {
            return optionalMovie.get();
        }
        return null;
    }

    @SuppressWarnings("null")
    @Override
    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie delete(int id) {
        Movie movie = findById(id);

        if (movie != null) {
            movieRepository.delete(movie);
        }
        return null;
    }

    @Override
    public Movie update(int id, Movie movie) {
        Movie movieFound = findById(id);

        movieFound.setActors(movie.getActors());
        movieFound.setDirectorName(movie.getDirectorName());
        movieFound.setName(movie.getName());
        movieFound.setRating(movie.getRating());
        movieFound.setReleaseDate(movie.getReleaseDate());

        return movieRepository.save(movieFound);
    }

}