package com.pokemon.pokeApi.controller;


import com.pokemon.pokeApi.entities.PokemonDetail;
import com.pokemon.pokeApi.service.impl.PokemonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/{identifier}")
    public ResponseEntity<PokemonDetail> getPokemon(@PathVariable String identifier) {
        PokemonDetail pokemon = pokemonService.getPokemon(identifier);
        return ResponseEntity.ok(pokemon);
    }

    @GetMapping("/abilities")
    public ResponseEntity<List<String>> getFirst50Abilities() {
        List<String> abilities = pokemonService.getFirst50Abilities();
        return ResponseEntity.ok(abilities);
    }
}
