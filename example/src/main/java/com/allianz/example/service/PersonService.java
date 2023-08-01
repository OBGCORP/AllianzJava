package com.allianz.example.service;

import com.allianz.example.model.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    public Person createPerson(String name, String surname, String tc, int birthYear) {
        Person person = new Person();
        person.setTc(tc);
        person.setName(name);
        person.setSurname(surname);
        person.setBirthYear(birthYear);
        return person;
    }
}
