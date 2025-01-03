package com.pokemon.pokeApi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("TRAINER")
@SuperBuilder
public class Trainer extends User{


    private String name;
    private String city;

    @ElementCollection
    private List<String> favoritePokemons;

    private int score;


}
