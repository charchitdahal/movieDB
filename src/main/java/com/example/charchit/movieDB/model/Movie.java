package com.example.charchit.movieDB.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@NoArgsConstructor
@Data
@Table(name = "movie")
public class Movie {

    @Id
    private long id;

    private String name;

    private String descript;

    @ManyToOne
    private Genre genre;

    @ManyToOne
    private Actor actor;

}
