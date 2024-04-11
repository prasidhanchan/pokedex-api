package com.kawaki.pokedex.services.impl;

import com.kawaki.pokedex.domain.Pokemon;
import com.kawaki.pokedex.repositories.PokemonRepository;
import com.kawaki.pokedex.services.PokemonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PokemonServiceImpl implements PokemonService {

    private final PokemonRepository pokemonRepository;

    public PokemonServiceImpl(final PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @Override
    public Pokemon addPokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    @Override
    public Page<Pokemon> getAllPokemon(Pageable pageable) {
        return pokemonRepository.findAll(pageable);
    }

    @Override
    public List<Pokemon> getPokemonByName(String name) {
        List<Pokemon> result = pokemonRepository.findAll();

        List<Pokemon> foundPokemon = result.stream()
                .filter(pokemon ->
                        pokemon.getName().toLowerCase().contains(name.toLowerCase())
                )
                .toList();

        if (foundPokemon.isEmpty()) {
            return Collections.emptyList();
        } else {
            return foundPokemon;
        }
    }

    @Override
    public Pokemon updatePokemon(
            String _id,
            Pokemon pokemon
    ) {
        pokemon.set_id(_id);
        return pokemonRepository.findById(_id).map(
                        existingPokemon -> {
                            Optional.ofNullable(pokemon.getName()).ifPresent(existingPokemon::setName);
                            Optional.ofNullable(pokemon.getImage()).ifPresent(existingPokemon::setImage);
                            Optional.ofNullable(pokemon.getColor()).ifPresent(existingPokemon::setColor);
                            Optional.ofNullable(pokemon.getDescription()).ifPresent(existingPokemon::setDescription);
                            Optional.ofNullable(pokemon.getType()).ifPresent(existingPokemon::setType);
                            Optional.ofNullable(pokemon.getCategory()).ifPresent(existingPokemon::setCategory);
                            Optional.ofNullable(pokemon.getHeight()).ifPresent(existingPokemon::setHeight);
                            Optional.ofNullable(pokemon.getWeight()).ifPresent(existingPokemon::setWeight);

                            return pokemonRepository.save(existingPokemon);
                        }
                )
                .orElseThrow(() -> new RuntimeException("Pokemon not found!"));
    }

    @Override
    public void removePokemon(String _id) {
        pokemonRepository.deleteById(_id);
    }

    @Override
    public boolean isExists(String _id) {
        return pokemonRepository.findById(_id).isPresent();
    }
}
