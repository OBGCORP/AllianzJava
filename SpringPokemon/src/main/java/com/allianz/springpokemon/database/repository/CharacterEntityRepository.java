package com.allianz.springpokemon.database.repository;

import com.allianz.springpokemon.database.entity.ArenaEntity;
import com.allianz.springpokemon.database.entity.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterEntityRepository extends JpaRepository<CharacterEntity, Long> {

    List<CharacterEntity> findAllByNameContainsIgnoreCase(String key);

    List<CharacterEntity> findAll();
}
