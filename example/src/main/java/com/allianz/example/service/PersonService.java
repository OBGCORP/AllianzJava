package com.allianz.example.service;

import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.database.repository.PersonEntityRepository;
import com.allianz.example.mapper.PersonMapper;
import com.allianz.example.model.PersonDTO;
import com.allianz.example.model.requestDTO.PersonRequestDTO;
import com.allianz.example.util.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
import java.util.UUID;

//bean
@Service
public class PersonService extends BaseService<PersonEntity, PersonDTO,
        PersonRequestDTO, PersonMapper, PersonEntityRepository> {

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private PersonEntityRepository personEntityRepository;

    @Override
    public PersonMapper getMapper() {
        return personMapper;
    }

    @Override
    public PersonEntityRepository getRepository() {
        return personEntityRepository;
    }
}
