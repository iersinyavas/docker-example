package com.artsoft.examapp.appsdk.util;


import com.artsoft.examapp.appsdk.lesson.Lesson;
import com.artsoft.examapp.appsdk.test.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestUtil {

    public Test createTest(String testName, Lesson... lessons){
        Map<String, List<Lesson>> lessonMap = new HashMap<>();
        lessonMap.put(testName, Arrays.asList(lessons));

        return Test.builder()
                .testName(testName)
                .lessonMap(lessonMap)
                .build();
    }

    public Test createTest(String testName, List<Lesson> lessonList){
        Map<String, List<Lesson>> lessonMap = new HashMap<>();
        lessonMap.put(testName, lessonList);

        return Test.builder()
                .testName(testName)
                .lessonMap(lessonMap)
                .build();
    }

}
