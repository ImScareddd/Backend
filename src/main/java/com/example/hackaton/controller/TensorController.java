package com.example.hackaton.controller;

import com.example.hackaton.dto.EmotionalScoreDto;
import com.example.hackaton.entity.EmotionalScore;
import com.example.hackaton.repository.EmotionalScoreRepository;
import com.example.hackaton.service.FlaskClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TensorController {

    @Autowired
    EmotionalScoreRepository emotionalScoreRepository;
    @Autowired
    FlaskClient flaskclient;


    @GetMapping("/Predict")
    public ResponseEntity<String> generateToDoList(@RequestParam long googleId){

        List<EmotionalScore> byGoogleId = emotionalScoreRepository.findByGoogleId(googleId);
        ArrayList<EmotionalScoreDto> emotionalScoreDtos = new ArrayList<>();
        for (EmotionalScore emotionalScore : byGoogleId) {
            long googleId1 = emotionalScore.getGoogleId();
            String date = emotionalScore.getDate();
            int emotionalScore1 = emotionalScore.getEmotionalScore();
            EmotionalScoreDto emotionalScoreDto = new EmotionalScoreDto(googleId1,date,emotionalScore1);
            emotionalScoreDtos.add(emotionalScoreDto);
        }
        flaskclient.trainModel(emotionalScoreDtos);
        flaskclient.predict(emotionalScoreDtos);
        return ResponseEntity.ok("Success");
    }
}
