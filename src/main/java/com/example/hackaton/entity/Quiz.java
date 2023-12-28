package com.example.hackaton.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "Quiz_table")
@Getter@Setter
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String googleId;
    private String date;
    private String question;
    private String answer;




}

