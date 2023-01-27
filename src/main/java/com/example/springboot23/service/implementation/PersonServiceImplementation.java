package com.example.springboot23.service.implementation;

import com.example.springboot23.entity.Person;
import com.example.springboot23.repository.PersonRepository;
import com.example.springboot23.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImplementation implements PersonService {

    private final PersonRepository repository;

    @Override
    public Person savePerson(Person person) {
        return repository.save(person);
    }
}
