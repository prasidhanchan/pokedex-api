package com.kawaki.pokedex.repository;

import com.kawaki.pokedex.domain.Pokemon;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PokemonRepository extends MongoRepository<Pokemon, String> { }
