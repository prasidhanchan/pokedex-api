package com.kawaki.pokedex.services;

import com.kawaki.pokedex.domain.Pokemon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PokemonService {
    Pokemon addPokemon(Pokemon pokemon);

    Page<Pokemon> getAllPokemon(Pageable pageable);

    List<Pokemon> getPokemonByName(String name);

    Pokemon updatePokemon(String _id, Pokemon pokemon);

    void removePokemon(String _id);

    boolean isExists(String _id);
}
