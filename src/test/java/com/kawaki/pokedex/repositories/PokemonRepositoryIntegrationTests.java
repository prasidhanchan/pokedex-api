package com.kawaki.pokedex.repositories;

import com.kawaki.pokedex.TestUtils;
import com.kawaki.pokedex.domain.Pokemon;
import com.kawaki.pokedex.services.PokemonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PokemonRepositoryIntegrationTests {

    PokemonRepository underTest;
    PokemonService pokemonService;

    @Autowired
    public PokemonRepositoryIntegrationTests(
            PokemonRepository underTest,
            PokemonService pokemonService
    ) {
        this.underTest = underTest;
        this.pokemonService = pokemonService;
    }

    @Test
    public void testAddPokemonToDB() {
        underTest.deleteAll();

        Pokemon pokemon = TestUtils.createPokemonA();
        Pokemon addedPokemon = pokemonService.addPokemon(pokemon);
        List<Pokemon> result = underTest.findById(pokemon.get_id()).stream().toList();
        assertThat(result).isNotEmpty();
        assertThat(result.get(0)).isEqualTo(addedPokemon);

        underTest.deleteAll();
    }

    @Test
    public void testDeletePokemonFromDB() {
        Pokemon pokemon = TestUtils.createPokemonA();

        underTest.save(pokemon);
        underTest.deleteById(pokemon.get_id());
        List<Pokemon> result = underTest.findById(pokemon.get_id()).stream().toList();
        assertThat(result).isEmpty();
    }

    @Test
    public void testGetAllPokemon() {
        underTest.deleteAll();

        Pokemon pokemonA = TestUtils.createPokemonA();
        Pokemon pokemonB = TestUtils.createPokemonB();
        underTest.save(pokemonA);
        underTest.save(pokemonB);

        List<Pokemon> result = underTest.findAll();
        assertThat(result).containsExactly(pokemonA, pokemonB);

        underTest.deleteAll();
    }

    @Test
    public void testGetPokemonByName() {
        underTest.deleteAll();

        Pokemon pokemonA = TestUtils.createPokemonA();
        underTest.save(pokemonA);
        List<Pokemon> result = pokemonService.getPokemonByName("Pikachu");

        assertThat(result.get(0)).isEqualTo(pokemonA);

        underTest.deleteAll();
    }

    @Test
    public void testUpdatePokemon() {
        underTest.deleteAll();

        Pokemon pokemonA = TestUtils.createPokemonA();
        underTest.save(pokemonA);
        Pokemon newPokemon = TestUtils.createUpdatedPokemon();
        newPokemon.set_id(pokemonA.get_id());
        Pokemon result = pokemonService.updatePokemon(pokemonA.get_id(), newPokemon);

        assertThat(result.getName()).isEqualTo(newPokemon.getName());

        underTest.deleteAll();
    }

    @Test
    public void testDeletePokemon() {
        underTest.deleteAll();

        Pokemon pokemonA = TestUtils.createPokemonA();
        underTest.save(pokemonA);

        pokemonService.removePokemon(pokemonA.get_id());
        List<Pokemon> result = underTest.findById(pokemonA.get_id()).stream().toList();

        assertThat(result).isEmpty();

        underTest.deleteAll();
    }

}
