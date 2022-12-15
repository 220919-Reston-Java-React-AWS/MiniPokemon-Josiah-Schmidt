package com.revature.demo.controller;

import com.revature.demo.model.Pokemon;
import com.revature.demo.repository.PokemonRepository;
import com.revature.demo.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    PokemonService ps;
    @Autowired
    PokemonRepository pr;

    @GetMapping("/one")
    public Pokemon getByName(@RequestBody String name) {
        return ps.getByName(name);
    }

    @GetMapping("/all")
    public List<Pokemon> getAllPokemon() {
        return ps.getAllPokemon();
    }

    @PostMapping("/add")
    public ResponseEntity<Pokemon> addPoke(@RequestBody Pokemon pokemon){
        return ResponseEntity.ok(this.ps.addPoke(pokemon));
    }

    @DeleteMapping("/{name}")
    void deletePoke (@PathVariable String name) {
        Pokemon pokemon = this.pr.findByname(name);
        int pokeId = pokemon.getId();
        this.pr.deleteById(pokeId);
    }

    @PatchMapping("/update")
    public ResponseEntity<Pokemon> updatePokeLevel(@RequestBody String name, int level) {
        Pokemon pokemon = this.pr.findByname(name);
        pokemon.setLevel(level);
        return ResponseEntity.ok(this.ps.addPoke(pokemon));
    }

}
