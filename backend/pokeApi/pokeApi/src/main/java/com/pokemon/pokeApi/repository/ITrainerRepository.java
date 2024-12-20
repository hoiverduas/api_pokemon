package com.pokemon.pokeApi.repository;

import com.pokemon.pokeApi.entities.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITrainerRepository extends JpaRepository<Trainer,Long> {


}
