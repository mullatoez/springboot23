package com.example.springboot23.repository.pokemon;

import com.example.springboot23.entity.pokemon.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
}
