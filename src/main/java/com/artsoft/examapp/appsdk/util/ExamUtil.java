package com.artsoft.examapp.appsdk.util;

import com.artsoft.examapp.appsdk.exam.Exam;
import com.artsoft.examapp.appsdk.lesson.Lesson;
import com.artsoft.examapp.appsdk.test.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class ExamUtil {

    public Exam createExam(String examName, Test... tests) {
        Map<String, List<Test>> testMap = new HashMap<>();
        testMap.put(examName, Arrays.asList(tests));

        return Exam.builder()
                .examName(examName)
                .testMap(testMap)
                .build();
    }

    public Exam createExam(String examName, List<Test> testList){
        Map<String, List<Test>> testMap = new HashMap<>();
        testMap.put(examName, testList);

        return Exam.builder()
                .examName(examName)
                .testMap(testMap)
                .build();
    }


}
