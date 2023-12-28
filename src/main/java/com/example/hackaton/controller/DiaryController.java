package com.example.hackaton.controller;

import com.example.hackaton.entity.EmotionalScore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/diary")
public class DiaryController {

    @PostMapping("/write")
    public ResponseEntity<String> diaryWrite(
            @RequestParam Long googleId,
            @RequestParam String date,
            @RequestParam int emotionalScore){

        return ResponseEntity.ok("Success");
    }
}
