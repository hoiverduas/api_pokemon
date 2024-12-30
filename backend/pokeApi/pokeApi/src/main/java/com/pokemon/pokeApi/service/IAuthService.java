package com.pokemon.pokeApi.service;

import com.pokemon.pokeApi.dto.AuthResponse;
import com.pokemon.pokeApi.dto.LoginDto;
import com.pokemon.pokeApi.dto.RegisterDto;

public interface IAuthService {

    AuthResponse login(LoginDto login);
    AuthResponse register(RegisterDto register);

}
