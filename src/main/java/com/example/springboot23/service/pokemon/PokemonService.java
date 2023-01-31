package com.example.springboot23.service.pokemon;

import com.example.springboot23.dto.pokemon.PokemonDTO;
import com.example.springboot23.entity.pokemon.Pokemon;

import java.util.List;

public interface PokemonService {

    PokemonDTO createPokemon(PokemonDTO pokemonDTO);

    List<PokemonDTO> getPokemons();
}