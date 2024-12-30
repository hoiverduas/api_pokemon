package com.pokemon.pokeApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.pokemon.pokeApi.feingClients")
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class PokeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokeApiApplication.class, args);
	}

}
