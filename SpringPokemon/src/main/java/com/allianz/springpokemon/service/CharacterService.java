package com.allianz.springpokemon.service;

import com.allianz.springpokemon.database.entity.CharacterEntity;
import com.allianz.springpokemon.database.repository.CharacterEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

    @Autowired
    CharacterEntityRepository characterEntityRepository;

    public CharacterEntity createCharacter(String name, String surname) {
        CharacterEntity character = new CharacterEntity();
        character.setName(name);
        character.setSurname(surname);

        characterEntityRepository.save(character);

        return character;
    }

    public List<CharacterEntity> getCharacterByNameIContains(String key) {
        return characterEntityRepository.findAllByNameContainsIgnoreCase(key);
    }

    public List<CharacterEntity> getAllCharacters() {
        return characterEntityRepository.findAll();
    }
}
