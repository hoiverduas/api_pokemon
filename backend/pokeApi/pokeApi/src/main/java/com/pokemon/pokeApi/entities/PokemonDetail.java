package com.pokemon.pokeApi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonDetail {

    private String name;
    private Integer height;
    private Integer weight;
    private List<Ability> abilities;
    private Species species;
    private List<Form> forms;

}
