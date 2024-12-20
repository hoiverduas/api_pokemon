package com.pokemon.pokeApi.feingClients;


import com.pokemon.pokeApi.dto.AbilityResponse;
import com.pokemon.pokeApi.entities.PokemonDetail;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pokemonApi", url = "https://pokeapi.co/api/v2")
public interface PokemonApiClient {

    @GetMapping("/pokemon/{identifier}")
    ResponseEntity<PokemonDetail> getPokemonByIdOrName(@PathVariable String identifier);

    @GetMapping("/ability?limit=50")
    ResponseEntity<AbilityResponse> getFirst50Abilities();
}
