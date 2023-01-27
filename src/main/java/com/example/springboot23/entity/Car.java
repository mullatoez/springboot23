package com.example.springboot23.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@Data
@Getter
@Setter
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String engineName;

}

class Engine {

    static void printCarEngineName(){

        var bmw = new Car(1,"BMW","V6");

        System.out.println("BMW has an engine called " + bmw.getEngineName());
    }

    public static void main(String[] args) {
        printCarEngineName();
    }
}
