package com.revature.demo.repository;

import com.revature.demo.model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrainerRepository extends JpaRepository<Trainer, Integer> {

    Optional<Trainer> findByName(String name);
}
