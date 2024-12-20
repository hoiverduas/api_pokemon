package com.pokemon.pokeApi.controller;


import com.pokemon.pokeApi.config.JwtUtil;
import com.pokemon.pokeApi.dto.LoginDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginDto loginDto) {
        UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword());

        Authentication authentication = this.authenticationManager.authenticate(login);
        System.out.println("authentication = " + authentication.isAuthenticated());
        System.out.println("authentication = " + authentication.getPrincipal());

        String jwt = this.jwtUtil.create(loginDto.getEmail());

        Map<String, String> response = new HashMap<>();
        response.put("token", jwt);

        return ResponseEntity.ok(response);
    }

}
