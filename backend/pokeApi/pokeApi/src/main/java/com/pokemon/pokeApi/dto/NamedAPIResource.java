package com.pokemon.pokeApi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NamedAPIResource {

    private String name;
    private String url;

}
