package com.allianz.springpokemon.service;

import com.allianz.springpokemon.database.entity.PokemonEntity;
import com.allianz.springpokemon.database.repository.PokemonEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {

    @Autowired
    PokemonEntityRepository pokemonEntityRepository;

    public PokemonEntity createPokemon(String name, String ability) {
        PokemonEntity pokemon = new PokemonEntity();
        pokemon.setName(name);
        pokemon.setAbility(ability);

        pokemonEntityRepository.save(pokemon);

        return pokemon;
    }

    public List<PokemonEntity> getPokemonByNameIContains(String key) {
        return pokemonEntityRepository.findAllByNameContainsIgnoreCase(key);
    }

    public List<PokemonEntity> getAllPokemons() {
        return pokemonEntityRepository.findAll();
    }
}
