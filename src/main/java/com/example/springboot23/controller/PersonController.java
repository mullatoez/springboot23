package com.example.springboot23.controller;

import com.example.springboot23.entity.Person;
import com.example.springboot23.repository.PersonRepository;
import com.example.springboot23.service.PersonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService service;

    @PostMapping("/save")
    public Person savePerson(@RequestBody Person person){
        return service.savePerson(person);
    }
}
