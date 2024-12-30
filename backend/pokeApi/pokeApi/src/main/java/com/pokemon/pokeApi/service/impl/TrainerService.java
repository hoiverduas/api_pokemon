package com.pokemon.pokeApi.service.impl;

import com.pokemon.pokeApi.entities.Trainer;
import com.pokemon.pokeApi.exception.UsernameNotFound;
import com.pokemon.pokeApi.repository.ITrainerRepository;
import com.pokemon.pokeApi.service.ITrainerService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TrainerService implements ITrainerService {

    @Autowired
    private  final ITrainerRepository trainerRepository;
    private final PasswordEncoder passwordEncoder;

    public TrainerService(ITrainerRepository trainerRepository, PasswordEncoder passwordEncoder) {
        this.trainerRepository = trainerRepository;

        this.passwordEncoder = passwordEncoder;
    }



    @Override
    public Page<Trainer> findAllTrainersPageable(Pageable pageable) {
        return trainerRepository.findAll(pageable);
    }

    @Override
    public List<Trainer> findAllTrainers() {
        return this.trainerRepository.findAll();
    }

    public Trainer updateTrainer(Long id, Trainer trainer) throws UsernameNotFound {
        Trainer existingTrainer = trainerRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFound("Trainer not found"));
        existingTrainer.setName(trainer.getName());
        existingTrainer.setCity(trainer.getCity());
        existingTrainer.setFavoritePokemons(trainer.getFavoritePokemons());
        existingTrainer.setScore(trainer.getScore());
        return trainerRepository.save(existingTrainer);
    }

    @Override
    public Trainer findByIdTrainer(Long id) throws UsernameNotFound {
        return this.trainerRepository
                 .findById(id)
                  .orElseThrow(() -> new UsernameNotFound("Trainer  with id not found " +  id));
    }

    @Override
    public void deleteTrainer(Long id) throws UsernameNotFound {
        findByIdTrainer(id);
        trainerRepository.deleteById(id);
    }
}
