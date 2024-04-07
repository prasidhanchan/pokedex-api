package com.kawaki.pokedex.controllers;

import com.kawaki.pokedex.domain.Pokemon;
import com.kawaki.pokedex.services.impl.PokemonServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PokemonController {

    final PokemonServiceImpl pokemonService;

    @Value("${KEY}")
    public String KEY;

    public PokemonController(final PokemonServiceImpl pokemonService) {
        this.pokemonService = pokemonService;
    }

    @PostMapping(path = "/add-pokemon")
    public ResponseEntity<String> addPokemon(
            @RequestParam(required = false) String key,
            @RequestBody Pokemon pokemon
    ) {
        if (key != null && key.equals(KEY)) {
            pokemonService.addPokemon(pokemon);
            return new ResponseEntity<>(
                    "Pokemon added successfully",
                    HttpStatus.CREATED
            );
        } else if (key != null) {
            return new ResponseEntity<>(
                    "Invalid key!",
                    HttpStatus.UNAUTHORIZED
            );
        } else {
            return new ResponseEntity<>(
                    "This operation requires a key, ex: /add-pokemon?key=KEY",
                    HttpStatus.UNAUTHORIZED
            );
        }
    }

    @GetMapping(path = "/get-all-pokemon")
    public Page<Pokemon> getAllPokemon(Pageable pageable) {
        return pokemonService.getAllPokemon(pageable);
    }

    @GetMapping(path = "/get-pokemon/{name}")
    public ResponseEntity<List<Pokemon>> getPokemonByName(@PathVariable String name) {
        List<Pokemon> pokemonList = pokemonService.getPokemonByName(name);

        if (pokemonList.isEmpty()) {
            return new ResponseEntity<>(
                    pokemonList,
                    HttpStatus.NOT_FOUND
            );
        } else {
            return new ResponseEntity<>(pokemonList, HttpStatus.OK);
        }
    }

    @PatchMapping(path = "/update-pokemon/{_id}")
    public ResponseEntity<String> updatePokemon(
            @RequestParam(required = false) String key,
            @PathVariable String _id,
            @RequestBody Pokemon pokemon
    ) {
        if (key != null && key.equals(KEY)) {
            if (pokemonService.isExists(_id)) {
                pokemonService.updatePokemon(_id, pokemon);
                return new ResponseEntity<>(
                        "Pokemon updated successfully",
                        HttpStatus.OK
                );
            } else {
                return new ResponseEntity<>(
                        "Pokemon not found!",
                        HttpStatus.NOT_FOUND
                );
            }
        } else if (key != null) {
            return new ResponseEntity<>(
                    "Invalid key!",
                    HttpStatus.UNAUTHORIZED
            );
        } else {
            return new ResponseEntity<>(
                    "This operation requires a key, ex: /update-pokemon?key=KEY",
                    HttpStatus.UNAUTHORIZED
            );
        }
    }

    @DeleteMapping(path = "/remove-pokemon/{_id}")
    public ResponseEntity<String> removePokemon(
            @RequestParam(required = false) String key,
            @PathVariable String _id
    ) {
        if (key != null && key.equals(KEY)) {
            if (pokemonService.isExists(_id)) {
                pokemonService.removePokemon(_id);
                return new ResponseEntity<>(
                        "Pokemon removed successfully",
                        HttpStatus.OK
                );
            } else {
                return new ResponseEntity<>(
                        "Pokemon not found!",
                        HttpStatus.NOT_FOUND
                );
            }
        } else if (key != null) {
            return new ResponseEntity<>(
                    "Invalid key!",
                    HttpStatus.UNAUTHORIZED
            );
        } else {
            return new ResponseEntity<>(
                    "This operation requires a key, ex: /remove-pokemon?key=KEY",
                    HttpStatus.UNAUTHORIZED
            );
        }
    }

}
