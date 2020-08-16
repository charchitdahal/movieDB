package com.example.charchit.movieDB.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.example.charchit.movieDB.model.Movie;

public interface MovieRepo extends JpaRepository<Movie, Long> {

}
