package com.allianz.springpokemon.controller;

import com.allianz.springpokemon.database.entity.ArenaEntity;
import com.allianz.springpokemon.database.entity.CharacterEntity;
import com.allianz.springpokemon.model.Character;
import com.allianz.springpokemon.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("character")
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @PostMapping("create-character")
    public ResponseEntity<CharacterEntity> createCharacter(@RequestBody Character character) {
        CharacterEntity character1 = characterService.createCharacter(character.getName(), character.getSurname());
        return new ResponseEntity<>(character1, HttpStatus.CREATED);
    }

    @GetMapping("character-name-icontains/{key}")
    public ResponseEntity<List<CharacterEntity>> getCharactersByNameIContains(@PathVariable String key) {
        return new ResponseEntity<>(characterService.getCharacterByNameIContains(key), HttpStatus.OK);
    }

    @GetMapping("character-list")
    public ResponseEntity<List<CharacterEntity>> getAllCharacters() {
        return new ResponseEntity<>(characterService.getAllCharacters(), HttpStatus.OK);
    }
}
