package com.kawaki.pokedex.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Pokemon {
    @Id
    @Builder.Default
    private String _id = ObjectId.get().toHexString();
    private String name;
    @Builder.Default
    private String image = "";
    @Builder.Default
    private String color = "0XFF00AFFF";
    private String description;
    private String type;
    private String category;
    private String height;
    private String weight;
}
