package com.example.charchit.movieDB.repository;

// using Spring Data JPA to store and receive data in relational db.
import com.example.charchit.movieDB.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepo extends JpaRepository<Genre, Long> {

    Genre findByName(String name);
}
