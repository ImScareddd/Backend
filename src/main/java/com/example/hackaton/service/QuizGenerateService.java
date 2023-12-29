package com.example.hackaton.service;

import com.example.hackaton.dto.QuizDto;
import com.pkslow.ai.AIClient;
import com.pkslow.ai.GoogleBardClient;
import com.pkslow.ai.domain.Answer;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class QuizGenerateService {

    private static final String TOKEN = "ewiOCiyTcXwDoR0GWnhPpcEu_pLqKpPtVx4Wr_VNnLTJSWEhUpP_QZz6pokVskP65Vlm3g.;bE0CiwOjO8Tg9hrw/AimjbslWZuEIM4ycL";

    public List<QuizDto> ask(String question) {
        AIClient client = new GoogleBardClient(TOKEN);
        Answer answer = client.ask(question+"\n 이를 바탕으로 문제 3개 내줘 \n Question: [질문 내용]'과 'Answer: [답변 내용]");
        String chosenAnswer = answer.getChosenAnswer();
        List<QuizDto> quizDtos = extractQuestionAndAnswer(chosenAnswer);
        return quizDtos;
    }

    // 정규 표현식을 이용해 'question'과 'answer' 추출 후 QuizDto 리스트로 반환
    public List<QuizDto> extractQuestionAndAnswer(String text) {
        List<QuizDto> quizzes = new ArrayList<>();

        Pattern questionPattern = Pattern.compile("Question: (.*?)\\.");
        Pattern answerPattern = Pattern.compile("Answer: (.*?)\\.");

        Matcher questionMatcher = questionPattern.matcher(text);
        Matcher answerMatcher = answerPattern.matcher(text);

        while (questionMatcher.find() && answerMatcher.find()) {
            String question = questionMatcher.group(1);
            String answer = answerMatcher.group(1);

            // 각 질문과 답변 쌍을 QuizDto 객체로 생성하고 리스트에 추가
            quizzes.add(new QuizDto(question, answer));
        }

        // 모든 QuizDto 객체를 포함하는 리스트 반환
        return quizzes;
    }
}


