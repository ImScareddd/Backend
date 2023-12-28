package com.example.hackaton.controller;

import com.example.hackaton.dto.QuizDto;
import com.example.hackaton.entity.Diary;
import com.example.hackaton.entity.Image;
import com.example.hackaton.repository.DiaryRepository;
import com.example.hackaton.repository.ImageRepository;
import com.example.hackaton.service.ImageGenerateService;
import com.example.hackaton.service.QuizGenerateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/diary")
public class DiaryController {


    private final DiaryRepository diaryRepository;
    private final ImageGenerateService imageGenerateService;
    private final ImageRepository imageRepository;
    private final QuizGenerateService quizGenerateService;

    @PostMapping("/write")
    public ResponseEntity<String> diaryWrite(
            @RequestParam Long googleId,
            @RequestParam String date,
            @RequestParam String time,
            @RequestParam String diary){

        Diary diary1 = new Diary(googleId, date, time, diary);
        diaryRepository.save(diary1);

        return ResponseEntity.ok("Success");
    }

    @GetMapping("/list")
    public ResponseEntity<List<Diary>> diaryList(
            @RequestParam Long googleId,
            @RequestParam String date
    ){

        List<Diary> byGoogleIdAndDateAndTime = diaryRepository.findByGoogleIdAndDate(googleId, date);

        return ResponseEntity.ok(byGoogleIdAndDateAndTime);
    }

    @GetMapping("/generateImage")
    public ResponseEntity<String> generateImage(
            @RequestParam Long googleId,
            @RequestParam String date
    ){

        List<Diary> byGoogleIdAndDateAndTime = diaryRepository.findByGoogleIdAndDate(googleId, date);

        String s = "";
        for (Diary diary : byGoogleIdAndDateAndTime) {
            String diary1 = diary.getDiary();
            s += diary1;
        }

        Image image = new Image();
        String imageUrl = imageGenerateService.openAiImageUrl(s);

        System.out.println("imageUrl = " + imageUrl);


        image.setUrl(imageUrl);
        image.setDate(date);
        image.setGoogleId(googleId);

        log.info("Image generated: {}", image);
        imageRepository.save(image);
        return ResponseEntity.ok(imageUrl);
    }

    @GetMapping("/image")
    public ResponseEntity<String> Image(
            @RequestParam Long googleId,
            @RequestParam String date
    ){
        Image byGoogleIdAndDate = imageRepository.findByGoogleIdAndDate(googleId, date);
        String url = byGoogleIdAndDate.getUrl();

        return ResponseEntity.ok(url);
    }

    @GetMapping("/quizGenerate")
    public ResponseEntity<List<QuizDto>> generateQuiz(
            @RequestParam Long googleId,
            @RequestParam String date
    ){
        List<Diary> byGoogleIdAndDateAndTime = diaryRepository.findByGoogleIdAndDate(googleId, date);

        String s = "";
        for (Diary diary : byGoogleIdAndDateAndTime) {
            String diary1 = diary.getDiary();
            s += diary1;
        }
        List<QuizDto> ask = quizGenerateService.ask(s);

        return ResponseEntity.ok(ask);
    }
}
