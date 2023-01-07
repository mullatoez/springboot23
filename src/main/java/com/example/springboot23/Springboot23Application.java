package com.example.springboot23;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class Springboot23Application {
/*exclude = {DataSourceAutoConfiguration.class }*/
    public static void main(String[] args) {
        SpringApplication.run(Springboot23Application.class, args);
    }

}
