package com.revature.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "pokemons")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int num;

    private String name;

    private int level;

    private String image;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    private Trainer trainer;

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", numId=" + num +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", image='" + image + '\'' +
                ", trainer=" + trainer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return id == pokemon.id && num == pokemon.num && level == pokemon.level && Objects.equals(name, pokemon.name) && Objects.equals(image, pokemon.image) && Objects.equals(trainer, pokemon.trainer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, num, name, level, image, trainer);
    }
}
