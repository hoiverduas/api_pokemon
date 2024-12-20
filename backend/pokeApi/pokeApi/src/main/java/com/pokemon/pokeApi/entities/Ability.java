package com.pokemon.pokeApi.entities;

import com.pokemon.pokeApi.dto.NamedAPIResource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ability {
    private NamedAPIResource ability;

}
