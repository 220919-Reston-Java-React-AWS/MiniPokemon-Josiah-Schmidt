package com.revature.demo.service;

import com.revature.demo.excpetion.NotFoundException;
import com.revature.demo.model.Pokemon;
import com.revature.demo.model.Trainer;
import com.revature.demo.repository.PokemonRepository;
import com.revature.demo.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerService {

    @Autowired
    TrainerRepository tr;

    @Autowired
    PokemonRepository pr;


    public Trainer getTrainer(int id){
        Optional<Trainer> trainerOption = tr.findById(id);

        if (trainerOption.isEmpty()){
            throw new NotFoundException("Trainer Not Found");
        }

        return trainerOption.get();
    }

    public Trainer upsertTrainer(Trainer trainer){
        return tr.save(trainer);
    }

    public Trainer addPokemonToParty(int trainerId, Pokemon pokemon){
        Trainer trainer = getTrainer(trainerId);


        List<Pokemon> party = trainer.getPokemons();
        party.add(pokemon);

        return upsertTrainer(trainer);
    }
}
