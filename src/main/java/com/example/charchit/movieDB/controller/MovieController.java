package com.example.charchit.movieDB.controller;

import com.example.charchit.movieDB.model.Genre;
import com.example.charchit.movieDB.model.Movie;
import com.example.charchit.movieDB.repository.GenreRepo;
import com.example.charchit.movieDB.repository.MovieRepo;
import jdk.jfr.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MovieController {

    private MovieRepo movieRepo;

    public MovieController( MovieRepo movieRepo){
        super();
        this.movieRepo = movieRepo;
    }

    @GetMapping("/movie")
    Collection<Movie> movie(){
        return movieRepo.findAll();
    }

    @GetMapping("/movie/{id}")
    ResponseEntity<?> getMovie(@PathVariable Long id){
        Optional<Movie> movie = movieRepo.findById(id);
        return movie.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/movie")
    ResponseEntity<Movie> createMovie(@Validated @RequestBody Movie movie) throws URISyntaxException{
        Movie result = movieRepo.save(movie);
        return ResponseEntity.created(new URI("api/movie" + result.getId())).body(result);

    }

    @PutMapping("/movie/{id}")
    ResponseEntity<Movie> updateMovie (@Validated @RequestBody Movie movie){
        Movie result = movieRepo.save(movie);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/movie/{id}")
    ResponseEntity<Movie> deleteMovie(@PathVariable Long id){
        movieRepo.deleteById(id);
        return ResponseEntity.ok().build();

    }

}