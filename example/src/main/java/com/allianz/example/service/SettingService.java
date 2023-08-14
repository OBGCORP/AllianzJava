package com.allianz.example.service;

import com.allianz.example.database.entity.SettingEntity;
import com.allianz.example.database.repository.SettingEntityRepository;
import com.allianz.example.mapper.SettingMapper;
import com.allianz.example.model.SettingDTO;
import com.allianz.example.model.requestDTO.SettingRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SettingService extends BaseService<SettingEntity,SettingDTO,
        SettingRequestDTO, SettingMapper, SettingEntityRepository> {

    @Autowired
    private SettingMapper settingMapper;

    @Autowired
    private SettingEntityRepository settingEntityRepository;


    @Override
    public SettingMapper getMapper() {
        return settingMapper;
    }

    @Override
    public SettingEntityRepository getRepository() {
        return settingEntityRepository;
    }
}
