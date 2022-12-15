package com.revature.demo.service;

import com.revature.demo.model.Pokemon;
import com.revature.demo.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {

    @Autowired
    PokemonRepository pr;

    public List<Pokemon> getAllPokemon(){
        return this.pr.findAll();
    }

    public Pokemon getByName(String name) {
        return this.pr.findByname(name);
    }

    public Pokemon addPoke(Pokemon pokemon){
        return this.pr.save(pokemon);
    }
}
