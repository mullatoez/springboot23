package com.example.springboot23.controller;

import com.example.springboot23.entity.Student;
import com.example.springboot23.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {



    private final StudentRepository studentRepository;

    @GetMapping("/list")
    public List<Student> getAllStudent(){
        studentRepository.saveAll(getStudents());
        return studentRepository.findAll();
    }

    List<Student> getStudents(){
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(1,"Kevin","Kyei"));
        students.add(new Student(2,"Victor","Mugo"));
        students.add(new Student(3,"Kaka","Musili"));
        students.add(new Student(4,"Roseanne","Maina"));

        return students;

    }
}
