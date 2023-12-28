package com.example.hackaton.service;


import com.example.hackaton.entity.Image;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PromptService {


    public String promptService(Image imageToRequest){

        String date = imageToRequest.getDate();
        String prompt = imageToRequest.getPrompt();


        return prompt;
    }
}

