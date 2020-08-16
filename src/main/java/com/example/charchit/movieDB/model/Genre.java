package com.example.charchit.movieDB.model;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "genre")

public class Genre {

    @Id
    private Long id;

    @NotNull
    private String name;





}
