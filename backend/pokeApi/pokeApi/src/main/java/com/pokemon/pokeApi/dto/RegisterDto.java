package com.pokemon.pokeApi.dto;

import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class RegisterDto {

    private String password;
    private String email;
    private String name;
    private String city;
    @ElementCollection
    private List<String> favoritePokemons;
    private int score;
}
