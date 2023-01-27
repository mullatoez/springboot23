package com.example.springboot23.repository;

import com.example.springboot23.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; //bean

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
/*
3 LAYERS
1--- Repository layer == DB Level
2--- Service layer == LOGIC(PERSON --SAVE A person to db)
3--- Controller == WEB(RESTFUL APIS)
 */