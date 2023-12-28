package com.example.hackaton.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "Image_table")
@Getter@Setter
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private long googleId;
    private String date;
    @Column(length = 500)
    private String url;

    public Image() {
    }

    public Image(String date, String url) {
        this.date = date;
        this.url = url;
    }




}
