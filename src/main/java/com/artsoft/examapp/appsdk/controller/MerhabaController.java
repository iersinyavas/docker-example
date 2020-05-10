package com.artsoft.examapp.appsdk.controller;

import com.artsoft.examapp.appsdk.domain.StudentDto;
import com.artsoft.examapp.appsdk.exam.Exam;
import com.artsoft.examapp.appsdk.lesson.Lesson;
import com.artsoft.examapp.appsdk.test.Test;
import com.artsoft.examapp.appsdk.util.ExamUtil;
import com.artsoft.examapp.appsdk.util.JsonConverter;
import com.artsoft.examapp.appsdk.util.LessonConfig;
import com.artsoft.examapp.appsdk.util.TestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController("/")
public class MerhabaController {

    @Autowired
    TestUtil testUtil;

    @Autowired
    LessonConfig lessonConfig;

    @Autowired
    ExamUtil examUtil;

    @Autowired
    JsonConverter jsonConverter;

    @GetMapping("/merhaba")
    public String merhaba(){
        return "index";
    }

    @GetMapping("/student")
    public ResponseEntity<StudentDto> studentDto(){
        Map<String, List<Lesson>> lessonMap = lessonConfig.getLessonMap();
        Test turkish = testUtil.createTest("Türkçe", lessonMap.get("Türkçe"));
        Test math = testUtil.createTest("Matematik", lessonMap.get("Matematik"));
        Test social = testUtil.createTest("Sosyal", lessonMap.get("Sosyal"));
        Test science = testUtil.createTest("Fen", lessonMap.get("Fen"));
        Exam exam = examUtil.createExam("YGS", turkish, math, social, science);

        Map<String, Exam> examMap = new HashMap<>();
        examMap.put(exam.getExamName(), exam);

        return new ResponseEntity<StudentDto>(jsonConverter.studentCreate1(examMap), HttpStatus.OK);
    }
}
