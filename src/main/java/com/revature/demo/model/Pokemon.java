package com.revature.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pokemons")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numId;
    private String name;
    private int level;
    private String image;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    private Trainer trainer;
}
