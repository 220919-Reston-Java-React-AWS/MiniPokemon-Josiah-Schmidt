package com.revature.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "trainers")
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int trainerId;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trainer", fetch = FetchType.LAZY)
    private List<Pokemon> pokemons;
}
