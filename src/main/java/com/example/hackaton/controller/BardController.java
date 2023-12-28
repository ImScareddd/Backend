package com.example.hackaton.controller;


import com.pkslow.ai.AIClient;
import com.pkslow.ai.GoogleBardClient;
import com.pkslow.ai.domain.Answer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/google-bard")
public class BardController {


    @GetMapping("/ask")
    public String ask(@RequestParam("q") String q) {

        String token = "ewiOCrmVQvT-9fBIGD3gjjH7-Vs4oyYGrli0fO8NNpaSCJYZj97u5g6y0877NGiGu8styA.;sidts-CjEBPVxjSpEQNcCUKuF96RDuMFhTJDARZjwGBi7zp3FcQ5heZPENPcBkIrOvlec-soDZEAA";
        AIClient client = new GoogleBardClient(token);
        Answer answer = client.ask(q);
        String chosenAnswer = answer.getChosenAnswer();

        return chosenAnswer;
    }
}