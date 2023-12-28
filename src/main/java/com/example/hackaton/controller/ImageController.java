package com.example.hackaton.controller;

import com.example.hackaton.entity.Image;
import com.example.hackaton.entity.User;
import com.example.hackaton.repository.ImageRepository;
import com.theokanning.openai.image.CreateImageRequest;
import com.theokanning.openai.service.OpenAiService;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;


@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ImageController {

    private final ImageRepository imageRepository;

    @Value("${openai-key}")
    private String OPENAI_KEY;


    @PostMapping("/generate/image")
    public ResponseEntity<String> generateImage(

            @RequestParam String date,
            @RequestParam String prompt) {


        Image image = new Image();
        image.setPrompt(prompt);
        String imageUrl = openAiImageUrl(image);

        System.out.println("imageUrl = " + imageUrl);


        image.setEmail(email);
        image.setUrl(imageUrl);
        image.setEmail("1");
        image.setDate(date);
//        File file = new File(imageUrl);
//        String image1 = awsS3Service.upload(file, "Image");
//        image.setUrl(image1);
//        image.setDate(date);

        log.info("Image generated: {}", image);
        imageRepository.save(image);
        return ResponseEntity.ok("generate Success");
    }

    @PostMapping("/generate/sleepDiary")
    public ResponseEntity<String> generateDiary(
            @SessionAttribute(name = "loginUser", required = false) User loginUser,
            @RequestParam String date,
            @RequestParam String caffeineIntake,
            @RequestParam String caffeineIntakeTime,
            @RequestParam String Exercise,
            @RequestParam String ExerciseTime,
            @RequestParam String pill,
            @RequestParam String pillDosage,
            @RequestParam String SleepTime,
            @RequestParam String wakeUpTime) {

        SleepDiary sleepDiary = new SleepDiary(date,Integer.parseInt(caffeineIntake),Integer.parseInt(caffeineIntakeTime),Integer.parseInt(Exercise),Integer.parseInt(ExerciseTime),pill,Integer.parseInt(pillDosage),Integer.parseInt(SleepTime),Integer.parseInt(wakeUpTime));

        System.out.println("caffeineIntake = " + caffeineIntake);

        System.out.println("sleepDiary = " + sleepDiary);

        if (loginUser != null) {
            String email = loginUser.getEmail();
            sleepDiary.setEmail(email);
        }

        log.info("Diary generated: {}", sleepDiary);


        sleepDiaryRepository.save(sleepDiary);
        return ResponseEntity.ok("generate Success");
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
