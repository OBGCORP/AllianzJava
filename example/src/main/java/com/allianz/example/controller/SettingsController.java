package com.allianz.example.controller;

import com.allianz.example.database.entity.SettingsEntity;
import com.allianz.example.model.SettingsDTO;
import com.allianz.example.model.requestDTO.SettingRequestDTO;
import com.allianz.example.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/settings")
public class SettingsController {

    @Autowired
    SettingsService settingsService;

    @PostMapping("/create")
    public ResponseEntity<SettingsEntity> createSettings(@RequestBody SettingRequestDTO request) {
        SettingsEntity createdSettings = settingsService.createSettings(request.getKey(), request.getValue());
        return new ResponseEntity<>(createdSettings, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<SettingsDTO>> getAllSettings() {
        List<SettingsDTO> settings = settingsService.getAllSettings();
        return new ResponseEntity<>(settings, HttpStatus.OK);
    }

    @GetMapping("/get/{uuid}")
    public ResponseEntity<SettingsDTO> getSettingsByUUID(@PathVariable UUID uuid) {
        SettingsDTO settingsDTO = settingsService.getByUUID(uuid);
        return new ResponseEntity<>(settingsDTO, HttpStatus.OK);
    }

    @PutMapping("/update/{uuid}")
    public ResponseEntity<SettingsEntity> updateSettings(@PathVariable UUID uuid, @RequestBody SettingRequestDTO request) {
        SettingsEntity updatedSettings = settingsService.updateSettings(uuid, request.getKey(), request.getValue());
        return new ResponseEntity<>(updatedSettings, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{uuid}")
    public ResponseEntity<Void> deleteSettings(@PathVariable UUID uuid) {
        settingsService.deleteSettings(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
