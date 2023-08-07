package com.allianz.example.controller;

import com.allianz.example.database.entity.PersonEntity;
import com.allianz.example.model.PersonDTO;
import com.allianz.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("person")
public class PersonController {


    //endpoint->son nokta-bitis noktası

    //localhost:8080/example

    @Autowired
    PersonService personService;

    @PostMapping("person")
    public ResponseEntity<PersonEntity> createPerson(@RequestBody PersonDTO person){

        PersonEntity person1 = personService.createPerson(person.getName(), person.getSurname(),
                person.getTc(), person.getBirthYear());

        return new ResponseEntity<>(person1, HttpStatus.CREATED);
    }

    @DeleteMapping("person/{uuid}")
    public ResponseEntity<Boolean> deletePerson(@PathVariable UUID uuid) {

        Boolean isDeleted = personService.deletePersonByUUID(uuid);
        if (isDeleted) {
            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(Boolean.FALSE, HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("person-list-by-name-start-with/{key}")
    public ResponseEntity<List<PersonEntity>> getPersonListByNameStartWith(@PathVariable String key) {

        return new ResponseEntity<>(personService.getPersonNameStartWith(key), HttpStatus.OK);
    }


    @GetMapping("person-list-by-name-i-contains/{key}")
    public ResponseEntity<List<PersonEntity>> getPersonListByNameICOntains(@PathVariable String key) {
        return new ResponseEntity<>(personService.getPersonNameIContains(key), HttpStatus.OK);
    }


    @GetMapping("person-list-by-name-surname-start-with/name/{name}/surname/{surname}")
    public ResponseEntity<List<PersonEntity>> getPersonListByNameICOntains(
            @PathVariable String name, @PathVariable String surname) {
        return new ResponseEntity<>(
                personService.getPersonNameStartWithAndSurnameStartWith(name, surname), HttpStatus.OK);
    }


    @GetMapping("person-by-uuid/{uuid}")
    public ResponseEntity<PersonEntity> getPersonByUUID(@PathVariable UUID uuid) {

        PersonEntity personEntity = personService.getPersonByUUID(uuid);

        if (personEntity != null) {

            return new ResponseEntity<>(personEntity, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }


    }

    @PutMapping("person/{uuid}")
    public ResponseEntity<PersonEntity> updatePersonByUUID(@PathVariable UUID uuid,
                                                           @RequestBody PersonEntity personEntityNew) {
        PersonEntity personEntity = personService.updatePersonByUUID(uuid, personEntityNew);
        if (personEntity != null) {

            return new ResponseEntity<>(personEntity, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }

    }


}