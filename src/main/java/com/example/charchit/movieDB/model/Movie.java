package com.example.charchit.movieDB.model;

//import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@NoArgsConstructor
@Data
@Table(name = "movie")

public class Movie {

    @Id
    private Long id;

    private String name;

    private String description;

    private String genre;




}
