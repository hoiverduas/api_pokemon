package com.pokemon.pokeApi.service.impl;


import com.pokemon.pokeApi.entities.User;
import com.pokemon.pokeApi.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserSecurityService implements UserDetailsService {

    private final IUserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    @Lazy
    public UserSecurityService(IUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = this.userRepository.findByEmail(username)
                .orElseThrow(()-> new UsernameNotFoundException("User" + username + "Not found"));



        // En un método donde necesites convertirlo a String[]
        String[] roles = { user.getRole() };

        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .authorities(this.grantedAuthorities(roles))
                .build();


    }


    private String[] getAuthorities(String roles){

        if ("TRAINER".equals(roles)){
            return new  String[] {"ROLE_TRAINER"};
        }


        return new String[] {};

    }


    private List<GrantedAuthority> grantedAuthorities(String[] roles) {
        List<GrantedAuthority> authorities = new ArrayList<>(roles.length);
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));

            for (String authority : this.getAuthorities(role)) {

                authorities.add(new SimpleGrantedAuthority(authority));

            }
        }
        return authorities;
    }
}
