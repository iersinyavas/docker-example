package com.artsoft.examapp.appsdk;

import com.artsoft.examapp.appsdk.domain.Result;
import com.artsoft.examapp.appsdk.domain.ResultScore;
import com.artsoft.examapp.appsdk.lesson.*;
import com.artsoft.examapp.appsdk.lesson.Math;
import com.artsoft.examapp.appsdk.util.JsonConverter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class AppSdkApplication implements CommandLineRunner {

    @Autowired
    JsonConverter jsonConverter;

    @Autowired
    ObjectMapper objectMapper;

    public static void main(String[] args) {
        SpringApplication.run(AppSdkApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Lesson> lessonList = Arrays.asList(
                Math.builder()
                        .lessonName("Matematik")
                        .build(),
                Turkish.builder()
                        .lessonName("Türkçe")
                        .build(),
                Science.builder()
                        .lessonName("Fen")
                        .build(),
                Social.builder()
                        .lessonName("Sosyal")
                        .build()
        );

        while (true) {
            try {

                String s = jsonConverter.resultCreate(lessonList.stream());
                System.out.println(s);
                Thread.sleep(2000);
                Result result = objectMapper.readValue(s, Result.class);
                System.out.println(result.getDigitalScore());

            } catch (InterruptedException | JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }


}
