package com.pokemon.pokeApi.controller;

import com.pokemon.pokeApi.entities.Trainer;
import com.pokemon.pokeApi.exception.UsernameNotFound;
import com.pokemon.pokeApi.service.impl.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trainers")
public class TrainerController {

    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }



    @GetMapping("/allTrainers")
    public ResponseEntity<List<Trainer>>  getAllTrainers(){
       try {
           return ResponseEntity
                   .status(HttpStatus.OK)
                   .body(trainerService.findAllTrainers());
       }catch (RuntimeException e){
           return ResponseEntity
                   .status(HttpStatus.NOT_FOUND).build();
       }
    }


    @GetMapping
    public ResponseEntity<Page<Trainer>> getAllTrainersPageable(Pageable pageable) {
        try {
            Page<Trainer> trainersPage = trainerService.findAllTrainersPageable(pageable);
            return ResponseEntity
                    .status(HttpStatus.OK)
                          .body(trainersPage);

        }catch (RuntimeException e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trainer> getByIdTrainer(@PathVariable Long id) throws UsernameNotFound {
       try {
           return ResponseEntity
                   .status(HttpStatus.OK)
                   .body(this.trainerService.findByIdTrainer(id));
       }catch (RuntimeException e){
           return ResponseEntity
                   .status(HttpStatus.NOT_FOUND).build();
       }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trainer> updateTrainer(@PathVariable Long id, @RequestBody Trainer trainer) throws UsernameNotFound {
       try {
           return ResponseEntity.
                   status(HttpStatus.OK)
                   .body(this.trainerService.updateTrainer(id, trainer));
       }catch (RuntimeException e){
           return ResponseEntity.
                   status(HttpStatus.NOT_FOUND).build();
       }
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrainer(@PathVariable Long id) throws UsernameNotFound {
       try {
           trainerService.deleteTrainer(id);
           return ResponseEntity
                   .status(HttpStatus.OK).build();
       }catch (RuntimeException e){
           return ResponseEntity
                   .status(HttpStatus.NOT_FOUND).build();

       }
    }

}
