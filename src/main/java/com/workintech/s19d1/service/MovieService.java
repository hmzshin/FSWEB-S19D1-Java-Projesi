package com.workintech.s19d1.service;

import java.util.List;

import com.workintech.s19d1.entity.Movie;

public interface MovieService {
    List<Movie> findAll();

    Movie findById(int id);

    Movie save(Movie movie);

    Movie delete(int id);

    Movie update(int id, Movie movie);
}