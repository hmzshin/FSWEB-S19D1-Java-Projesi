package com.workintech.s19d1.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workintech.s19d1.dto.MovieDto;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.service.MovieService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    @GetMapping
    public List<Movie> findAll() {
        return movieService.findAll();
    }

    @GetMapping("/{id}")
    public MovieDto getById(@PathVariable Integer id) {

        Movie movie = movieService.findById(id);

        return new MovieDto(movie.getId(), movie.getName(), movie.getDirectorName());
    }

    @PostMapping
    public MovieDto add(@RequestBody Movie movie) {
        Movie movieSaved = movieService.save(movie);

        return new MovieDto(movieSaved.getId(), movieSaved.getName(), movieSaved.getDirectorName());
    }

    @PostMapping("/{id}")
    public MovieDto update(@PathVariable int id, @RequestBody Movie movie) {

        Movie updatedMovie = movieService.update(id, movie);

        return new MovieDto(updatedMovie.getId(), updatedMovie.getName(), updatedMovie.getDirectorName());
    }

    @DeleteMapping("/{id}")
    public MovieDto delete(@PathVariable int id) {
        Movie deletedMovie = movieService.delete(id);

        return new MovieDto(deletedMovie.getId(), deletedMovie.getName(), deletedMovie.getDirectorName());
    }
}