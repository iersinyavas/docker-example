package com.artsoft.examapp.appsdk;

import com.artsoft.examapp.appsdk.domain.StudentDto;
import com.artsoft.examapp.appsdk.exam.Exam;
import com.artsoft.examapp.appsdk.lesson.Lesson;
import com.artsoft.examapp.appsdk.repository.StudentRepository;
import com.artsoft.examapp.appsdk.test.Test;
import com.artsoft.examapp.appsdk.util.ExamUtil;
import com.artsoft.examapp.appsdk.util.JsonConverter;
import com.artsoft.examapp.appsdk.util.LessonConfig;
import com.artsoft.examapp.appsdk.util.TestUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class AppSdkApplication implements CommandLineRunner {

    @Autowired
    LessonConfig lessonConfig;

    @Autowired
    JsonConverter jsonConverter;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ExamUtil examUtil;

    @Autowired
    TestUtil testUtil;

    @Autowired
    StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(AppSdkApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Map<String, List<Lesson>> lessonMap = lessonConfig.getLessonMap();
        Test turkish = testUtil.createTest("Türkçe", lessonMap.get("Türkçe"));
        Test math = testUtil.createTest("Matematik", lessonMap.get("Matematik"));
        Test social = testUtil.createTest("Sosyal", lessonMap.get("Sosyal"));
        Test science = testUtil.createTest("Fen", lessonMap.get("Fen"));
        Exam exam = examUtil.createExam("YGS", turkish, math, social, science);

        Map<String, Exam> examMap = new HashMap<>();
        examMap.put(exam.getExamName(), exam);

        while (true) {
            try {
                String s = jsonConverter.studentCreate(examMap);
                System.out.println(s);
                Thread.sleep(2000);
                StudentDto studentDto = objectMapper.readValue(s, StudentDto.class);
                /*Student student = Student.builder()
                        .digitalScore(studentDto.getResult().getDigitalScore())
                        .equalFocusScore(studentDto.getResult().getEqualFocusScore())
                        .verbalScore(studentDto.getResult().getVerbalScore())
                        .build();
                studentRepository.save(student);*/
            } catch (InterruptedException | JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }


}
