package com.cl.demo.controllers;


import com.cl.demo.entities.Person;
import com.cl.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("person")

public class PersonController {

    @Autowired
    public PersonService personService;

    @PostMapping("add")
     public Map<String, String> addPerson(@RequestBody Person person) {
        return personService.addPerson(person);

    }
    @GetMapping("getById")
    public Person getPersoneById(@RequestParam String uuid){
        return personService.getPersonById(uuid);
    }

    @GetMapping("getAll")
    public List<Person> getAllPerson(){
        return personService.getAllPersin();
    }
}
