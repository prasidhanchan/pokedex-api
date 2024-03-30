package com.kawaki.pokedex.services;

import com.kawaki.pokedex.domain.Pokemon;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PokemonService {
    Pokemon addPokemon(Pokemon pokemon);

    List<Pokemon> getAllPokemon();

    List<Pokemon> getPokemonByName(String name);

    Pokemon updatePokemon(String _id, Pokemon pokemon);

    void removePokemon(String _id);

    boolean isExists(String _id);
}
