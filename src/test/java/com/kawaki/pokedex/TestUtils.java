package com.kawaki.pokedex;

import com.kawaki.pokedex.domain.Pokemon;

public class TestUtils {
    public static Pokemon createPokemonA() {
        return Pokemon.builder()
                .name("Pikachu")
                .image("image URL")
                .color("0XFF000000")
                .description("This is a test Pikachu")
                .type("Electric")
                .category("Mouse")
                .height("1' 04")
                .weight("13.2")
                .build();
    }
    public static Pokemon createPokemonB() {
        return Pokemon.builder()
                .name("Charizard")
                .image("image URL")
                .color("0XFF000000")
                .description("This is a test Charizard")
                .type("Fire")
                .category("Dragon")
                .height("5' 11")
                .weight("100.2")
                .build();
    }

    public static Pokemon createUpdatedPokemon() {
        return Pokemon.builder()
                .name("Pichu")
                .build();
    }
}
