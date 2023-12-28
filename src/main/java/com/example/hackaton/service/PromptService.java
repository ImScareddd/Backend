package com.example.hackaton.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PromptService {


    public String promptService(Image imageToRequest){

        String date = imageToRequest.getDate();
        String prompt = imageToRequest.getPrompt();

        if (byDate.isPresent()) {
            SleepDiary sleepDiary = byDate.get();
            int sleepTime = sleepDiary.getSleepTime();

            if(sleepTime<3){
                prompt= prompt +",black";
            } else if (sleepTime<6) {
                prompt= prompt +",Red";
            } else if (sleepTime<8) {
                prompt= prompt +",yellow";
            } else if (sleepTime >= 8) {
                prompt= prompt +",green";
            }
        }
        return prompt;
    }
}

