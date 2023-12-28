package com.example.hackaton.dto;

public class QuizDto {
    private String question;
    private String answer;

    // 생성자
    public QuizDto(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    // question과 answer의 getter 메서드
    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    // 편의를 위한 toString 메서드
    @Override
    public String toString() {
        return "QuizDto{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}