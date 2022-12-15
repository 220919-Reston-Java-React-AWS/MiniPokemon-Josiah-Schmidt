package com.revature.demo.controller;

import com.revature.demo.model.Pokemon;

import com.revature.demo.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("trainers")
@CrossOrigin(origins = {"http://localhost:3000"})
public class TrainerController {

    @Autowired
    TrainerService ts;

    @GetMapping
    public ResponseEntity getById(@PathVariable int id){
        return ResponseEntity.ok( ts.getTrainer(id) );
    }

    @PutMapping
    public ResponseEntity addPokemon(@PathVariable int id, @RequestBody Pokemon pokemon){
        return ResponseEntity.ok( ts.addPokemonToParty(id, pokemon) );
    }
}
