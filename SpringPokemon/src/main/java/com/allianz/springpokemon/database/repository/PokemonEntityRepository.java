package com.allianz.springpokemon.database.repository;

import com.allianz.springpokemon.database.entity.ArenaEntity;
import com.allianz.springpokemon.database.entity.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonEntityRepository extends JpaRepository<PokemonEntity, Long> {

    List<PokemonEntity> findAllByNameContainsIgnoreCase(String key);

    List<PokemonEntity> findAll();
}
