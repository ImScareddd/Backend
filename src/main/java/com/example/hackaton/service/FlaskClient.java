package com.example.hackaton.service;

import com.example.hackaton.dto.EmotionalScoreDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.List;

@Service
public class FlaskClient {
    private static final String TRAIN_ENDPOINT = "http://ec2-16-16-185-194.eu-north-1.compute.amazonaws.com:5000/train";
    private static final String PREDICT_ENDPOINT = "http://ec2-16-16-185-194.eu-north-1.compute.amazonaws.com:5000/predict";

    // 모델 훈련 요청
    public void trainModel(List<EmotionalScoreDto> trainingData) {
        RestTemplate restTemplate = new RestTemplate();

        // HTTP 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // HTTP 요청 생성
        HttpEntity<List<EmotionalScoreDto>> entity = new HttpEntity<>(trainingData, headers);

        // POST 요청 전송 및 응답 처리
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(TRAIN_ENDPOINT, entity, String.class);

            if(response.getStatusCode().is2xxSuccessful()) {
                System.out.println("Training successful. Response from Flask: " + response.getBody());
            } else {
                System.out.println("Training failed. Response: " + response.getStatusCode());
            }
        } catch (Exception e) {
            System.out.println("Error during training request: " + e.getMessage());
        }
    }

    // 예측 요청
    public void predict(List<EmotionalScoreDto> predictData) {
        RestTemplate restTemplate = new RestTemplate();

        // HTTP 헤더 설정
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // HTTP 요청 생성
        HttpEntity<List<EmotionalScoreDto>> entity = new HttpEntity<>(predictData, headers);

        // POST 요청 전송 및 응답 처리
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(PREDICT_ENDPOINT, entity, String.class);

            if(response.getStatusCode().is2xxSuccessful()) {
                System.out.println("Prediction successful. Response from Flask: " + response.getBody());
            } else {
                System.out.println("Prediction failed. Response: " + response.getStatusCode());
            }
        } catch (Exception e) {
            System.out.println("Error during prediction request: " + e.getMessage());
        }
    }
}
