package com.pokemon.pokeApi.dto;





import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbilityResponse {
    private List<NamedAPIResource> results;

}
