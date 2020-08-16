package com.example.charchit.movieDB.repository;

import com.example.charchit.movieDB.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepo extends JpaRepository<Genre, Long> {

    Genre findByName(String name);
}
