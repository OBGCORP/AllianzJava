package com.allianz.springpokemon.controller;

import com.allianz.springpokemon.database.entity.ArenaEntity;
import com.allianz.springpokemon.database.entity.PokemonEntity;
import com.allianz.springpokemon.model.Pokemon;
import com.allianz.springpokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pokemon")
public class PokemonController {

    @Autowired
    PokemonService pokemonService;

    @PostMapping("create-pokemon")
    public ResponseEntity<PokemonEntity> createCharacter(@RequestBody Pokemon pokemon) {
        PokemonEntity pokemon1 = pokemonService.createPokemon(pokemon.getName(), pokemon.getAbility());
        return new ResponseEntity<>(pokemon1, HttpStatus.CREATED);
    }

    @GetMapping("pokemon-name-icontains/{key}")
    public ResponseEntity<List<PokemonEntity>> getCharactersByNameIContains(@PathVariable String key) {
        return new ResponseEntity<>(pokemonService.getPokemonByNameIContains(key), HttpStatus.OK);
    }

    @GetMapping("pokemon-list")
    public ResponseEntity<List<PokemonEntity>> getAllPokemons() {
        return new ResponseEntity<>(pokemonService.getAllPokemons(), HttpStatus.OK);
    }
}
