package com.example.hackaton.controller;

import com.example.hackaton.entity.EmotionalScore;
import com.example.hackaton.entity.Image;

import com.example.hackaton.entity.ToDoList;
import com.example.hackaton.repository.EmotionalScoreRepository;
import com.example.hackaton.repository.ImageRepository;
import com.example.hackaton.repository.ToDoListRepository;
import com.example.hackaton.service.ImageGenerateService;
import com.theokanning.openai.image.CreateImageRequest;
import com.theokanning.openai.service.OpenAiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/toDoList")
public class ToDoListController {

    private final ImageRepository imageRepository;
    private final EmotionalScoreRepository emotionalScoreRepository;
    private final ToDoListRepository toDoListRepository;
    private final ImageGenerateService imageGenerateService;

    @PostMapping("/add")
    public ResponseEntity<String> generateToDoList(
            @RequestParam String googleId,
            @RequestParam String date,
            @RequestParam String todoList
    ){
        ToDoList toDoList = new ToDoList(0,googleId,date,todoList);
        toDoListRepository.save(toDoList);

        return ResponseEntity.ok("Success");
    }

    @PutMapping("/check")
    public ResponseEntity<String> checkToDoList(
            @RequestParam String googleId,
            @RequestParam String date,
            @RequestParam String todoList,
            @RequestParam String finishedDate
    ){
        ToDoList byGoogleIdAndDateAndTodoList = toDoListRepository.findByGoogleIdAndDateAndTodoList(googleId, date, todoList);
        byGoogleIdAndDateAndTodoList.setStatus(1);
        byGoogleIdAndDateAndTodoList.setFinishedDate(finishedDate);
        toDoListRepository.save(byGoogleIdAndDateAndTodoList);

        return ResponseEntity.ok("Success");
    }

    @GetMapping()
    public ResponseEntity<List<ToDoList>> postToDoList(
            @RequestParam String googleId,
            @RequestParam String date
    ){
        List<ToDoList> byGoogleIdAndDate = toDoListRepository.findByGoogleIdAndDate(googleId, date);

        return ResponseEntity.ok(byGoogleIdAndDate);
    }




}
