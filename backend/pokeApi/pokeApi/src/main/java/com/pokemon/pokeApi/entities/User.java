package com.pokemon.pokeApi.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;





@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String password;
    private String email;

    @Transient
    @JsonProperty("role")
    public String getRole() {
        return this.getClass().getAnnotation(DiscriminatorValue.class).value();
    }


}

