package com.allianz.example.service;

import com.allianz.example.model.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Value("${gizem:25}")
    int value;

    public Person createPerson(String name, String surname, String tc, int birthYear) {
        Person person = new Person();
        person.setTc(tc);
        person.setName(name);
        person.setSurname(surname);
        person.setBirthYear(birthYear);
        System.out.println(value);
        return person;
    }
}
