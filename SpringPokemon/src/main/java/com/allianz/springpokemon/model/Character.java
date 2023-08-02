package com.allianz.springpokemon.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Character {
    private UUID uuid;
    private String name;
    private String surname;

    public Character() {
        this.uuid = UUID.randomUUID();
    }
}
