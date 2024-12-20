package com.pokemon.pokeApi.service;

import com.pokemon.pokeApi.entities.Trainer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ITrainerService {

    Trainer createTrainer(Trainer trainer);
    Page<Trainer> findAllTrainersPageable(Pageable pageable);
    Trainer updateTrainer(Long id, Trainer trainer);
    Trainer findByIdTrainer(Long id);
    void deleteTrainer(Long id);
    List<Trainer> findAllTrainers();
}
