package com.example.springboot23.repository.pokemon;

import com.example.springboot23.entity.pokemon.Pokemon;
import com.example.springboot23.entity.pokemon.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {

}
