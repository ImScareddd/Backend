package com.example.hackaton.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "User_table")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String email;
    private String name;
    private long googleId;

    public User(String email, String name, long googleId) {
        this.email = email;
        this.name = name;
        this.googleId = googleId;
    }

    public User() {
    }
}