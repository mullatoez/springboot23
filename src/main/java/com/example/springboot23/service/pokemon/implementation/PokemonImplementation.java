package com.example.springboot23.service.pokemon.implementation;

import com.example.springboot23.dto.pokemon.PokemonDTO;
import com.example.springboot23.entity.pokemon.Pokemon;
import com.example.springboot23.entity.pokemon.PokemonResponse;
import com.example.springboot23.exception.PokemonNotFoundException;
import com.example.springboot23.repository.pokemon.PokemonRepository;
import com.example.springboot23.service.pokemon.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public PokemonResponse getPokemons(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Pokemon> pokemonPage = pokemonRepository.findAll(pageable);
        List<Pokemon> pokemons = pokemonPage.getContent();
        List<PokemonDTO> content = pokemons.stream().map(this::mapPokemoneToDTO).collect(Collectors.toList());

        PokemonResponse response = new PokemonResponse();
        response.setData(content);
        response.setPageNo(pokemonPage.getNumber());
        response.setPageSize(pokemonPage.getSize());
        response.setTotalElements(pokemonPage.getTotalElements());
        response.setTotalPages(pokemonPage.getTotalPages());
        response.setLast(pokemonPage.isLast());

        return response;
    }

    @Override
    public PokemonDTO getPokemonById(Integer id) {
        Pokemon pokemon = pokemonRepository.findById(id)
                .orElseThrow(() -> new PokemonNotFoundException("Pokemon could not be found"));
        return mapPokemoneToDTO(pokemon);
    }

    @Override
    public PokemonDTO updatePokemon(PokemonDTO pokemonDTO, int id) {
        Pokemon pokemon = pokemonRepository.findById(id)
                .orElseThrow(() -> new PokemonNotFoundException("Pokemon not found"));

        pokemon.setName(pokemonDTO.getName());
        pokemon.setType(pokemonDTO.getType());

        Pokemon updatePokemon = pokemonRepository.save(pokemon);

        return mapPokemoneToDTO(updatePokemon);
    }

    @Override
    public void deletePokemonById(int id) {
        pokemonRepository.deleteById(id);
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

    @Override
    public void deletePokemon(int id) {
        Pokemon pokemon = pokemonRepository.findById(id).orElseThrow(() -> new PokemonNotFoundException("Pokemon not found"));
        pokemonRepository.delete(pokemon);
    }
}
