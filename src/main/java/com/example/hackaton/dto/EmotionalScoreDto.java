package com.example.hackaton.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmotionalScoreDto {

    private String googleId;
    private String date;
    @JsonProperty("emotionalScore")
    private int emotionalScore;

    public EmotionalScoreDto(String googleId, String date, int emotionalScore) {
        this.googleId = googleId;
        this.date = date;
        this.emotionalScore = emotionalScore;
    }
}
