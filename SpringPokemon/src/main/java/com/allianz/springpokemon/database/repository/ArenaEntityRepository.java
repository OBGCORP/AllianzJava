package com.allianz.springpokemon.database.repository;

import com.allianz.springpokemon.database.entity.ArenaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArenaEntityRepository extends JpaRepository<ArenaEntity, Long> {

    List<ArenaEntity> findAllByNameContainsIgnoreCase(String key);

    List<ArenaEntity> findAll();
}
