package com.allianz.springpokemon.controller;

import com.allianz.springpokemon.database.entity.ArenaEntity;
import com.allianz.springpokemon.model.Arena;
import com.allianz.springpokemon.service.ArenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("arena")
public class ArenaController {

    @Autowired
    ArenaService arenaService;

    @PostMapping("create-arena")
    public ResponseEntity<ArenaEntity> createArena(@RequestBody Arena arena) {
        ArenaEntity arena1 = arenaService.createArena(arena.getName(), arena.getRegion());
        return new ResponseEntity<>(arena1, HttpStatus.CREATED);
    }

    @GetMapping("arena-name-icontains/{key}")
    public ResponseEntity<List<ArenaEntity>> getArenasByNameIContains(@PathVariable String key) {
        return new ResponseEntity<>(arenaService.getArenaByNameIContains(key), HttpStatus.OK);
    }

    @GetMapping("arena-list")
    public ResponseEntity<List<ArenaEntity>> getAllArenas() {
        return new ResponseEntity<>(arenaService.getAllArenas(), HttpStatus.OK);
    }
}
