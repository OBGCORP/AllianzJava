package com.allianz.springpokemon.service;

import com.allianz.springpokemon.database.entity.ArenaEntity;
import com.allianz.springpokemon.database.repository.ArenaEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArenaService {
    @Autowired
    ArenaEntityRepository arenaEntityRepository;

    public ArenaEntity createArena(String name, String region) {
        ArenaEntity arena = new ArenaEntity();
        arena.setName(name);
        arena.setRegion(region);

        arenaEntityRepository.save(arena);

        return arena;
    }

    public List<ArenaEntity> getArenaByNameIContains(String key) {
        return arenaEntityRepository.findAllByNameContainsIgnoreCase(key);
    }

    public List<ArenaEntity> getAllArenas() {
        return arenaEntityRepository.findAll();
    }
}
