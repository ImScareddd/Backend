package com.example.hackaton.service;


import com.example.hackaton.entity.Image;
import com.theokanning.openai.image.CreateImageRequest;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ImageGenerateService {

    @Value("${openai-key}")
    private String OPENAI_KEY;


    public String openAiImageUrl(String imageToRequest) {
        OpenAiService service = new OpenAiService(OPENAI_KEY);
        CreateImageRequest build = CreateImageRequest.builder()
                .prompt(imageToRequest+"\n 위의 하루 기록을 포괄하는 그림을 만들어줘\n 이미지 비율은 16:9로 해줘")
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
