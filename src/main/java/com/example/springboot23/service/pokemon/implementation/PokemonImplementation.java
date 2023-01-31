package com.example.springboot23.service.pokemon.implementation;

import com.example.springboot23.dto.pokemon.PokemonDTO;
import com.example.springboot23.entity.pokemon.Pokemon;
import com.example.springboot23.repository.pokemon.PokemonRepository;
import com.example.springboot23.service.pokemon.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonImplementation implements PokemonService {


    private PokemonRepository pokemonRepository;

    @Autowired
    public PokemonImplementation(PokemonRepository repository) {
        this.pokemonRepository = repository;
    }

    @Override
    public PokemonDTO createPokemon(PokemonDTO pokemonDTO) {
        Pokemon pokemon = new Pokemon();
        pokemon.setName(pokemonDTO.getName());
        pokemon.setType(pokemonDTO.getType());

        Pokemon newPokemon = pokemonRepository.save(pokemon);

        PokemonDTO pokemonResponse = new PokemonDTO();
        pokemonResponse.setId(newPokemon.getId());
        pokemonResponse.setName(newPokemon.getName());
        pokemonResponse.setType(newPokemon.getType());
        return pokemonResponse;
    }

    @Override
    public List<PokemonDTO> getPokemons() {
        var pokemons = pokemonRepository.findAll();
        return pokemons.stream().map(this::mapPokemoneToDTO).collect(Collectors.toList());
    }

    private PokemonDTO mapPokemoneToDTO(Pokemon pokemon) {
        PokemonDTO pokemonDTO = new PokemonDTO();
        pokemonDTO.setId(pokemon.getId());
        pokemonDTO.setName(pokemon.getName());
        pokemonDTO.setType(pokemon.getType());
        return pokemonDTO;
    }

    private Pokemon mapToEntity(PokemonDTO pokemonDTO) {
        Pokemon pokemon = new Pokemon();
        pokemon.setName(pokemonDTO.getName());
        pokemon.setType(pokemonDTO.getType());

        return pokemon;
    }
}
