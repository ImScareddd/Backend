package com.example.hackaton.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmotionalScoreDto {

    private Long googleId;
    private String date;
    @JsonProperty("emotionalScore")
    private int emotionalScore;

    public EmotionalScoreDto(Long googleId, String date, int emotionalScore) {
        this.googleId = googleId;
        this.date = date;
        this.emotionalScore = emotionalScore;
    }
}
