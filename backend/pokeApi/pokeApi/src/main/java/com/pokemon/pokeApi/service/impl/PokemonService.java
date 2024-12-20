package com.pokemon.pokeApi.service.impl;

import com.pokemon.pokeApi.dto.NamedAPIResource;
import com.pokemon.pokeApi.entities.PokemonDetail;
import com.pokemon.pokeApi.feingClients.PokemonApiClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonService {

    private final PokemonApiClient pokemonApiClient;

    public PokemonService(PokemonApiClient pokemonApiClient) {
        this.pokemonApiClient = pokemonApiClient;
    }


    public PokemonDetail getPokemon(String identifier) {
        return pokemonApiClient.getPokemonByIdOrName(identifier).getBody();
    }

    public List<String> getFirst50Abilities() {
        List<NamedAPIResource> abilities = pokemonApiClient.getFirst50Abilities().getBody().getResults();
        return abilities.stream()
                .map(NamedAPIResource::getName)
                .sorted()
                .collect(Collectors.toList());
    }
}
