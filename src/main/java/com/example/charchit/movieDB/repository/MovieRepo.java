package com.example.charchit.movieDB.repository;
import com.example.charchit.movieDB.model.Genre;
import com.example.charchit.movieDB.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MovieRepo extends JpaRepository<Movie, Long> {

    @Autowired
    Movie findByName(String name);

}
