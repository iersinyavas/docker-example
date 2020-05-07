package com.artsoft.examapp.appsdk;

import com.artsoft.examapp.appsdk.domain.Result;
import com.artsoft.examapp.appsdk.domain.StudentDto;
import com.artsoft.examapp.appsdk.entity.Student;
import com.artsoft.examapp.appsdk.lesson.*;
import com.artsoft.examapp.appsdk.lesson.Math;
import com.artsoft.examapp.appsdk.repository.StudentRepository;
import com.artsoft.examapp.appsdk.util.BaseVariable;
import com.artsoft.examapp.appsdk.util.JsonConverter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class AppSdkApplication implements CommandLineRunner {

    @Autowired
    JsonConverter jsonConverter;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(AppSdkApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Lesson> lessonList = Arrays.asList(
                Math.builder()
                        .baseVariable(
                                BaseVariable.builder()
                                    .lessonName("Matematik")
                                    .build())
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

                String s = jsonConverter.studentCreate(lessonList.stream());
                System.out.println(s);
                Thread.sleep(2000);
                StudentDto studentDto = objectMapper.readValue(s, StudentDto.class);
                System.out.println(studentDto.getResult().getDigitalScore());
                Student student = Student.builder()
                        .digitalScore(studentDto.getResult().getDigitalScore())
                        .equalFocusScore(studentDto.getResult().getEqualFocusScore())
                        .verbalScore(studentDto.getResult().getVerbalScore())
                        .build();
                studentRepository.save(student);
            } catch (InterruptedException | JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }


}
