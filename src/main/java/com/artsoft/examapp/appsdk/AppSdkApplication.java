package com.artsoft.examapp.appsdk;

import com.artsoft.examapp.appsdk.domain.StudentDto;
import com.artsoft.examapp.appsdk.entity.Student;
import com.artsoft.examapp.appsdk.exam.Exam;
import com.artsoft.examapp.appsdk.repository.StudentRepository;
import com.artsoft.examapp.appsdk.util.ExamUtil;
import com.artsoft.examapp.appsdk.util.JsonConverter;
import com.artsoft.examapp.appsdk.util.TestUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class AppSdkApplication implements CommandLineRunner {

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

        Exam exam = examUtil.createExam("YGS", testUtil.testPool());
        Map<String, Exam> examMap = new HashMap<>();
        examMap.put(exam.getExamName(), exam);

        while (true) {
            try {
                String s = jsonConverter.studentCreate(examMap);
                Thread.sleep(2000);
                StudentDto studentDto = objectMapper.readValue(s, StudentDto.class);
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
