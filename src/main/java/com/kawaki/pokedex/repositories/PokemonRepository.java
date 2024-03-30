package com.kawaki.pokedex.repositories;

import com.kawaki.pokedex.domain.Pokemon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends MongoRepository<Pokemon, String> { }
