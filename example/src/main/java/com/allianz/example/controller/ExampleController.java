package com.allianz.example.controller;

import com.allianz.example.model.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("example")
public class ExampleController {
    @GetMapping("hello-world")
    public ResponseEntity<String> helloWorldApi() {
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    @GetMapping("person")
    public ResponseEntity<Person> personApi() {
        Person person = new Person();
        person.setName("Berk");
        person.setSurname("Gunes");
        person.setBirthYear(1999);
        person.setTc("23531434930");

        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @GetMapping("person/{personId}")
    public ResponseEntity<Person> personGetByPersonIdApi(@PathVariable int personId) {
        Person person = new Person();

        if (personId == 1) {
            person.setName("Berk");
            person.setSurname("Gunes");
            person.setBirthYear(1999);
            person.setTc("23531434930");
        } else {
            person.setName("Gizem");
            person.setSurname("Kisa");
            person.setBirthYear(1992);
            person.setTc("23531467730");
        }
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @GetMapping("person-list")
    public ResponseEntity<List<Person>> getPersonList() {
        List<Person> list = new ArrayList<>();
        Person person = new Person();
        Person person1 = new Person();

        person.setName("Berk");
        person.setSurname("Gunes");
        person.setBirthYear(1999);
        person.setTc("23531434930");

        person1.setName("Gizem");
        person1.setSurname("Kisa");
        person1.setBirthYear(1992);
        person1.setTc("23531467730");

        list.add(person);
        list.add(person1);

        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("person-by-request-param")
    public ResponseEntity<Person> personGetByPersonIdRequestParamApi(@RequestParam int personId, @RequestParam String tc) {

        System.out.println(tc);
        Person person = new Person();
        if (personId == 1) {
            person.setName("Ali");
            person.setSurname("Kaya");
            person.setBirthYear(1999);
            person.setTc("23531434930");
        } else {
            person.setName("Gizem");
            person.setSurname("Kisa");
            person.setBirthYear(1992);
            person.setTc("23531467730");
        }
        return new ResponseEntity<>(person, HttpStatus.OK);
    }
}
