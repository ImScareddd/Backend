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

        String token = "ewiOCkkjoPiwRwY1EAAlS193NfXpX8KqC1aaSAj2_0ZKXQUA_PcfuZH8VFZ_CwikF1MyHw.;sidts-CjIBPVxjStqGyeHEMxO9m16sjzsp2OH4ewur_Ufljgb9_eH9P4H0WqPOnPzb3tPmP2SHbRAA";
        AIClient client = new GoogleBardClient(token);
        Answer answer = client.ask(q);
        String chosenAnswer = answer.getChosenAnswer();

        return chosenAnswer;
    }
}