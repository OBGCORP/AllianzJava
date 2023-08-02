package com.allianz.springpokemon.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Pokemon {
    private UUID uuid;
    private String name;
    private String ability;

    public Pokemon() {
        this.uuid = UUID.randomUUID();
    }
}
