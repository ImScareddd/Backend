package com.example.hackaton.controller;

import com.example.hackaton.entity.EmotionalScore;
import com.example.hackaton.entity.Image;

import com.example.hackaton.repository.EmotionalScoreRepository;
import com.example.hackaton.repository.ImageRepository;
import com.example.hackaton.service.PromptService;
import com.theokanning.openai.image.CreateImageRequest;
import com.theokanning.openai.service.OpenAiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ToDoListController {

    private final ImageRepository imageRepository;
    private final EmotionalScoreRepository emotionalScoreRepository;
    private final PromptService promptService;

    @Value("${openai-key}")
    private String OPENAI_KEY;

//    @PostMapping("/toDoList")
//    public ResponseEntity<String> generateToDoList(
//            @RequestParam String date,
//            @RequestParam String
//    )


    @PostMapping("/generate/image")
    public ResponseEntity<String> generateImage(

            @RequestParam String date,
            @RequestParam String prompt) {


        Image image = new Image();
        image.setPrompt(prompt);
        String imageUrl = openAiImageUrl(image);

        System.out.println("imageUrl = " + imageUrl);


        image.setUrl(imageUrl);
        image.setEmail("1");
        image.setDate(date);


        log.info("Image generated: {}", image);
        imageRepository.save(image);
        return ResponseEntity.ok("generate Success");
    }

    @PostMapping("/emotionalScore")
    public ResponseEntity<String> emotionalScore(
            @RequestParam int googleId,
            @RequestParam String date,
            @RequestParam int emotionalScore){

        EmotionalScore emotionalScore1 = new EmotionalScore(googleId, date, emotionalScore);
        emotionalScoreRepository.save(emotionalScore1);
        return ResponseEntity.ok("Success");
    }




    private String openAiImageUrl(Image imageToRequest) {
        OpenAiService service = new OpenAiService(OPENAI_KEY);
        String s = promptService.promptService(imageToRequest);
        CreateImageRequest build = CreateImageRequest.builder()
                .prompt(s)
                .n(1)
                .size("512x512")
                .build();

        String imgUrl = service.createImage(build)
                .getData()
                .get(0)
                .getUrl();

        return imgUrl;
    }


}
