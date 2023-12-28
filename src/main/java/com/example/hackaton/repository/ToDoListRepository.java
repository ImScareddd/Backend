package com.example.hackaton.repository;

import com.example.hackaton.entity.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoList,Long> {

    ToDoList save(ToDoList toDoList);

    ToDoList findByGoogleIdAndDateAndTodoList(String googleId, String date, String todoList);

    List<ToDoList> findByGoogleIdAndDate(String googleId, String date);

}
