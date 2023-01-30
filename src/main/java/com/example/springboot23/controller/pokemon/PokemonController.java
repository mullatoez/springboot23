package com.example.springboot23.controller.pokemon;

import com.example.springboot23.entity.pokemon.Pokemon;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class PokemonController {

    @GetMapping("pokemon")
    public ResponseEntity<List<Pokemon>> getPokemons(){
        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(new Pokemon(1,"Pokemon 1","Alligator"));
        pokemons.add(new Pokemon(2,"Pokemon 2","Ice Cube"));
        pokemons.add(new Pokemon(3,"Pokemon 3","Water"));
        pokemons.add(new Pokemon(4,"Pokemon 4","Fire"));

        return ResponseEntity.ok(pokemons);
    }
}
