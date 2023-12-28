package com.example.hackaton.service;

import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.Map;
import java.util.List;

public class Flaskclient {
    private static final String TRAIN_ENDPOINT = "ec2-16-16-185-194.eu-north-1.compute.amazonaws.com:5000";
    private static final String PREDICT_ENDPOINT = "ec2-16-16-185-194.eu-north-1.compute.amazonaws.com:5000";

    // 모델 훈련 요청
    public void trainModel(List<Map<String, Object>> trainingData) {

        RestTemplate restTemplate = new RestTemplate();

        // HTTP 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // HTTP 요청 생성
        HttpEntity<List<Map<String, Object>>> entity = new HttpEntity<>(trainingData, headers);

        // POST 요청 전송
        ResponseEntity<String> response = restTemplate.postForEntity(TRAIN_ENDPOINT, entity, String.class);

        // 응답 처리
        if(response.getStatusCode().is2xxSuccessful()) {
            System.out.println("Response from Flask: " + response.getBody());
        } else {
            // 오류 처리
        }
    }

    // 예측 요청
    public void predict(List<Map<String, Object>> predictData) {
        RestTemplate restTemplate = new RestTemplate();

        // HTTP 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // HTTP 요청 생성
        HttpEntity<List<Map<String, Object>>> entity = new HttpEntity<>(predictData, headers);

        // POST 요청 전송
        ResponseEntity<String> response = restTemplate.postForEntity(PREDICT_ENDPOINT, entity, String.class);

        // 응답 처리
        if(response.getStatusCode().is2xxSuccessful()) {
            System.out.println("Response from Flask: " + response.getBody());
        } else {
            // 오류 처리
        }
    }
}
