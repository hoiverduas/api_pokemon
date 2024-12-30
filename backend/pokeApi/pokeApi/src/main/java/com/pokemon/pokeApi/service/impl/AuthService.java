package com.pokemon.pokeApi.service.impl;

import com.pokemon.pokeApi.config.JwtUtil;
import com.pokemon.pokeApi.dto.AuthResponse;
import com.pokemon.pokeApi.dto.LoginDto;
import com.pokemon.pokeApi.dto.RegisterDto;
import com.pokemon.pokeApi.entities.Trainer;
import com.pokemon.pokeApi.entities.User;
import com.pokemon.pokeApi.repository.ITrainerRepository;
import com.pokemon.pokeApi.repository.IUserRepository;
import com.pokemon.pokeApi.service.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {

    private final ITrainerRepository trainerRepository;
    private final  IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;



    public AuthResponse register(RegisterDto register){

        if (userRepository.findByEmail(register.getEmail()).isPresent()) {
            throw new RuntimeException("El correo ya está registrado");
        }


        var user = Trainer.builder()
                .score(register.getScore())
                .city(register.getCity())
                .name(register.getName())
                .favoritePokemons(register.getFavoritePokemons())
                .password(this.passwordEncoder.encode(register.getPassword()))
                .email(register.getEmail())
                .build();

        this.trainerRepository.save(user);

        String jwt = jwtUtil.create(user.getEmail());

        return AuthResponse.builder()
                .token(jwt)
                .build();
    }

    public AuthResponse login(LoginDto login){

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        login.getEmail(),
                        login.getPassword()
                )
        );

        var  user = userRepository.findByEmail(login.getEmail())
                .orElseThrow(()-> new RuntimeException(" Not Found"));

        String jwt = jwtUtil.create(user.getEmail());

        return AuthResponse.builder()
                .token(jwt)
                .build();
    }

}
