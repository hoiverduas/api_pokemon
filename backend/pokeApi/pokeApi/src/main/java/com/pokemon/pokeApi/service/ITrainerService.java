package com.pokemon.pokeApi.service;

import com.pokemon.pokeApi.entities.Trainer;
import com.pokemon.pokeApi.exception.UsernameNotFound;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ITrainerService {


    Page<Trainer> findAllTrainersPageable(Pageable pageable);
    Trainer updateTrainer(Long id, Trainer trainer) throws UsernameNotFound;
    Trainer findByIdTrainer(Long id) throws UsernameNotFound;
    void deleteTrainer(Long id) throws UsernameNotFound;
    List<Trainer> findAllTrainers();
}
