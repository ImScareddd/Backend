package com.example.hackaton.dto;

public class EmotionalScoreDto {

    private int googleId;
    private String date;
    private int emotionalScore;

    public EmotionalScoreDto(int googleId, String date, int emotionalScore) {
        this.googleId = googleId;
        this.date = date;
        this.emotionalScore = emotionalScore;
    }
}
