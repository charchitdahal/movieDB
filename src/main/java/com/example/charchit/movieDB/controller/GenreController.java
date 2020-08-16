package com.example.charchit.movieDB.controller;

import com.example.charchit.movieDB.model.Genre;
import com.example.charchit.movieDB.repository.GenreRepo;
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
public class GenreController {

    private GenreRepo genreRepo;

    public GenreController( GenreRepo genreRepo){
        super();
        this.genreRepo = genreRepo;
    }

    @GetMapping("/genre")
    Collection<Genre> genre(){
        return genreRepo.findAll();
    }

    @GetMapping("/genre/{id}")
    ResponseEntity<?> getGenre(@PathVariable Long id){
        Optional<Genre> genre = genreRepo.findById(id);
        return genre.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/genre")
    ResponseEntity<Genre> createGenre(@Validated @RequestBody Genre genre) throws URISyntaxException{
        Genre result = genreRepo.save(genre);
        return ResponseEntity.created(new URI("api/genre" + result.getId())).body(result);

    }

    @PutMapping("/genre/{id}")
    ResponseEntity<Genre> updateGenre (@Validated @RequestBody Genre genre){
        Genre result = genreRepo.save(genre);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/genre/{id}")
    ResponseEntity<Genre> deleteGenre(@PathVariable Long id){
        genreRepo.deleteById(id);
        return ResponseEntity.ok().build();

    }

}
