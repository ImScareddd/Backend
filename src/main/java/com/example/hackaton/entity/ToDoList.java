package com.example.hackaton.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "ToDoList_table")
@Getter
@Setter
public class ToDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private int status;
    private String googleId;
    private String date;
    private String finishedDate;

    @Column(length = 500)
    private String todoList;

    public ToDoList(int status, String googleId, String date, String todoList) {
        this.status = status;
        this.googleId = googleId;
        this.date = date;
        this.todoList = todoList;
    }

    public ToDoList() {
    }
}