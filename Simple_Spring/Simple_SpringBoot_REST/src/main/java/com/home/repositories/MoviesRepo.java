package com.home.repositories;

import com.home.entities.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MoviesRepo extends CrudRepository<Movie, Long> {
    List<Movie> findAll();
    Movie findById(long id);
    Movie save(Movie movie);
}
