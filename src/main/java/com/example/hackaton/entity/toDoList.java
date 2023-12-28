package com.example.hackaton.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "ToDoList_table")
@Getter
@Setter
public class toDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private int status;
    private String date;

    @Column(length = 500)
    private String todoList;

}