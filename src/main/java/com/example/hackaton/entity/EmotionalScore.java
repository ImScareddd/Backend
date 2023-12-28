package com.example.hackaton.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "EmotonalScore_table")
@Getter
@Setter
public class EmotionalScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String googleId;
    private String date;
    private int emotionalScore;

    public EmotionalScore(String googleId, String date, int emotionalScore) {
        this.googleId = googleId;
        this.date = date;
        this.emotionalScore = emotionalScore;
    }

    public EmotionalScore() {

    }
}
