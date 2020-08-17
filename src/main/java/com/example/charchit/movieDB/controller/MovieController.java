package com.example.charchit.movieDB.controller;

import com.example.charchit.movieDB.model.Movie;
import com.example.charchit.movieDB.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")


public class MovieController{

    @Autowired private MovieRepo movieRepo;

    @GetMapping("/movie")
    List<Movie> getMovie(){
        return movieRepo.findAll();
    }

    @DeleteMapping("/movie/{id}")
    ResponseEntity<?> deleteMovie(@PathVariable Long id){
        movieRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/movie")
    ResponseEntity<Movie> createMovie(@Validated @RequestBody Movie movie) throws URISyntaxException {
        Movie result = movieRepo.save(movie);
        return ResponseEntity.created(new URI("/api/movie" + result.getId())).body(result);
    }



}