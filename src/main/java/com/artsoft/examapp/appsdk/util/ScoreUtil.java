package com.artsoft.examapp.appsdk.util;

import com.artsoft.examapp.appsdk.lesson.Lesson;
import com.artsoft.examapp.appsdk.score.ScoreType;

import java.util.Arrays;
import java.util.List;

public class ScoreUtil {

    public static float scoreCalculate(ScoreType scoreType, List<Lesson> lessonList){
        return lessonList.stream().map(lesson  -> scoreType.scoreCalculate(lesson)).reduce(0F, (a, b) -> Float.sum(a, b));
    }

    public static float scoreCalculate(ScoreType scoreType, Lesson... lessons){
        return Arrays.asList(lessons).stream().map(lesson  -> scoreType.scoreCalculate(lesson)).reduce(0F, (a, b) -> Float.sum(a, b));
    }

    public float scoreCalculate(ScoreType scoreType, Lesson lesson){
        return scoreType.scoreCalculate(lesson);
    }
}
