package com.example.hackaton.dto;

import com.example.hackaton.entity.EmotionalScore;

import java.util.List;

public class PredictDto {

    List<Double> predict;
    List<EmotionalScore> recentScores;

    public PredictDto(List<Double> predict, List<EmotionalScore> recentScores) {
        this.predict = predict;
        this.recentScores = recentScores;
    }
}
