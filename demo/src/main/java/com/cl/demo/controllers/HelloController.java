package com.cl.demo.controllers;

import com.cl.demo.entities.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/helloController")

public class HelloController {

    @GetMapping("1")
    public String hello() {
        return "Hello SALWA";
    }

    @GetMapping("data")
    public Person data(@RequestParam String name) {
        Person person = new Person();
        //person.setId(1l);
        person.setName(name);
        return person;
    }
}
