package com.artsoft.examapp.appsdk.util;


import com.artsoft.examapp.appsdk.lesson.Lesson;
import com.artsoft.examapp.appsdk.test.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class TestUtil {

    @Autowired
    LessonConfig lessonConfig;

    @Autowired
    TestUtil testUtil;

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

    public List<Test> testPool(){
        Map<String, List<Lesson>> lessonMap = lessonConfig.getLessonMap();
        List<Test> testList = new ArrayList<>();

        lessonMap.entrySet().stream().forEach(
                stringListEntry -> testList.add(testUtil.createTest(stringListEntry.getKey(), lessonMap.get(stringListEntry.getKey())))
        );

        return testList;
    }

}
