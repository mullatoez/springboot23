package com.example.springboot23.controller.pokemon;

import com.example.springboot23.dto.pokemon.PokemonDTO;
import com.example.springboot23.entity.pokemon.Pokemon;
import com.example.springboot23.entity.pokemon.PokemonResponse;
import com.example.springboot23.service.pokemon.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public PokemonController(PokemonService service) {
        this.pokemonService = service;
    }

    @GetMapping("pokemon")
    public ResponseEntity<List<Pokemon>> getPokemons() {
        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(new Pokemon(1, "Pokemon 1", "Alligator"));
        pokemons.add(new Pokemon(2, "Pokemon 2", "Ice Cube"));
        pokemons.add(new Pokemon(3, "Pokemon 3", "Water"));
        pokemons.add(new Pokemon(4, "Pokemon 4", "Fire"));

        return ResponseEntity.ok(pokemons);
    }

    @DeleteMapping("pokemon/{id}/delete")
    public ResponseEntity<String> deletePokemon(@PathVariable int id) {
        System.out.println(id);
        return ResponseEntity.ok("Pokemon id " + id + "deleted successfully");
    }

    @PostMapping("create")
    public ResponseEntity<PokemonDTO> createPokemon(@RequestBody PokemonDTO pokemonDTO) {
        return ResponseEntity.ok(pokemonService.createPokemon(pokemonDTO));
    }

    @GetMapping("pokemons")
    public ResponseEntity<PokemonResponse> getAllPokemons(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize
    ) {
        return new ResponseEntity<>(pokemonService.getPokemons(pageNo, pageSize), HttpStatus.OK);
    }

    @GetMapping("pokemon/{id}")
    public ResponseEntity<PokemonDTO> getPokemonById(@PathVariable("id") int id) {
        return ResponseEntity.ok(pokemonService.getPokemonById(id));
    }

    @PutMapping("pokemon/update/{id}")
    public ResponseEntity<PokemonDTO> updatePokemon(@PathVariable int id,
                                                    @RequestBody PokemonDTO pokemonDTO) {

        return ResponseEntity.ok(pokemonService.updatePokemon(pokemonDTO, id));
    }

    @DeleteMapping("pokemon/{id}")
    public ResponseEntity<String> deletePokemonById(@PathVariable int id) {
        pokemonService.deletePokemonById(id);
        return new ResponseEntity<>("Pokemon deleted successfully", HttpStatus.OK);
    }
}
