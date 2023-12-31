package com.example.hackaton.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Diary_table")
@Getter@Setter
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String googleId;
    private String date;
    private String time;
    @Column(length = 500)
    private String diary;

    public Diary(String googleId, String date, String time, String diary) {
        this.googleId = googleId;
        this.date = date;
        this.time = time;
        this.diary = diary;
    }

    public Diary() {
    }
}
