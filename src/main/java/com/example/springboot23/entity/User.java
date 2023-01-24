package com.example.springboot23.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import java.io.Serializable;

@Entity
@Table(name = "table_users")
public class User implements Serializable {

    @Id
    private Long id;

    private String username;

    private String password;

    @Transient
    private String repeatedPassword;

    public User(Long id, String username, String password, String repeatedPassword) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.repeatedPassword = repeatedPassword;
    }

    public User() {
    }
}
