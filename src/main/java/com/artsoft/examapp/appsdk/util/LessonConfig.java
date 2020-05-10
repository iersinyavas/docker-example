package com.artsoft.examapp.appsdk.util;

import com.artsoft.examapp.appsdk.lesson.Lesson;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class LessonConfig {

    Map<String, List<Lesson>> lessonMap = new HashMap<>();

    public LessonConfig(Map<String, List<Lesson>> lessonMap){
        this.lessonMap = lessonMap;
    }
}
