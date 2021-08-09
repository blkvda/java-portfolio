package com.home.controller;

import com.home.entities.Movie;
import com.home.repositories.MoviesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "movie", produces = "application/json")
public class MovieRestController {
    @Autowired
    private MoviesRepo moviesRepo;

    public MovieRestController(MoviesRepo moviesRepo) {
        this.moviesRepo = moviesRepo;
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Movie>> getAllMovies(){
        List<Movie> result = moviesRepo.findAll();
        if(result == null || result.size() == 0){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<Movie> getMovieById(@PathVariable(name = "id") long movieId){
        Movie movie = moviesRepo.findById(movieId);
        if(movie == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PutMapping("/put")
    public ResponseEntity<Movie> putMovie(@RequestBody Movie movie){
        if(movie == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(moviesRepo.save(movie), HttpStatus.CREATED);
    }
}
