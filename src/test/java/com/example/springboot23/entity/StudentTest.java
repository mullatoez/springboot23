package com.example.springboot23.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.not;
import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class StudentTest {

    void givenPerson_whenSerialized_idIgnored() throws JsonProcessingException {

        Student student = new Student(1,"Kevin","Kyei");

        String result = new ObjectMapper().writeValueAsString(student);



    }
}