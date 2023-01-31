package com.example.springboot23.controller.pokemon;

import com.example.springboot23.dto.pokemon.PokemonDTO;
import com.example.springboot23.entity.pokemon.Pokemon;
import com.example.springboot23.service.pokemon.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class PokemonController {

    private PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService service){
        this.pokemonService = service;
    }

    @GetMapping("pokemon")
    public ResponseEntity<List<Pokemon>> getPokemons(){
        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(new Pokemon(1,"Pokemon 1","Alligator"));
        pokemons.add(new Pokemon(2,"Pokemon 2","Ice Cube"));
        pokemons.add(new Pokemon(3,"Pokemon 3","Water"));
        pokemons.add(new Pokemon(4,"Pokemon 4","Fire"));

        return ResponseEntity.ok(pokemons);
    }

    @DeleteMapping("pokemon/{id}/delete")
    public ResponseEntity<String> deletePokemon(@PathVariable("id") int pokemonId){
        System.out.println(pokemonId);
        return ResponseEntity.ok("Pokemon id " + pokemonId + "deleted successfully");
    }

    @PostMapping("create")
    public ResponseEntity<PokemonDTO> createPokemon(@RequestBody PokemonDTO pokemonDTO){
        return ResponseEntity.ok(pokemonService.createPokemon(pokemonDTO));
    }

    @GetMapping("pokemons")
    public ResponseEntity<List<PokemonDTO>> getAllPokemons(){
        return ResponseEntity.of(Optional.ofNullable(pokemonService.getPokemons()));
    }
}
