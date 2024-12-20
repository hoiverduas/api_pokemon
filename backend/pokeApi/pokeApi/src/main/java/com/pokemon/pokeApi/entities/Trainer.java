package com.pokemon.pokeApi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("TRAINER")
public class Trainer extends User{


    private String name;
    private String city;

    @ElementCollection
    private List<String> favoritePokemons;

    private int score;


}
