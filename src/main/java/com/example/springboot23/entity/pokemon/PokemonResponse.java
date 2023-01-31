package com.example.springboot23.entity.pokemon;

import com.example.springboot23.dto.pokemon.PokemonDTO;
import lombok.Data;

import java.util.List;

@Data
public class PokemonResponse {
    private List<PokemonDTO> data;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean last;

}
