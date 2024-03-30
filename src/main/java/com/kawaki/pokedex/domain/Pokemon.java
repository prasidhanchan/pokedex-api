package com.kawaki.pokedex.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pokemon {
    private String name;
    private String description;
    private String type;
    private String category;
    private String height;
    private String weight;
}
