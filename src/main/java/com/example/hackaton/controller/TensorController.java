package com.example.hackaton.controller;

import com.example.hackaton.entity.EmotionalScore;
import com.example.hackaton.repository.EmotionalScoreRepository;
import com.example.hackaton.service.Flaskclient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping()
public class TensorController {

    EmotionalScoreRepository emotionalScoreRepository;
    Flaskclient flaskclient;


    @GetMapping("/Predict")
    public ResponseEntity<String> generateToDoList(@RequestParam long googleId){

        List<EmotionalScore> byGoogleId = emotionalScoreRepository.findByGoogleId(googleId);
        flaskclient.trainModel(byGoogleId);
    }
}
