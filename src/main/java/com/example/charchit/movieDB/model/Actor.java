package com.example.charchit.movieDB.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@AllArgsConstructor
@Entity
@Data
@Table(name="actors")

public class Actor {

    @Id
    private Long id;
    private String name;

    // to be added later
//    @OneToMany
//    private Set<Genre> genre;

}
