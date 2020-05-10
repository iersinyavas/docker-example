package com.artsoft.examapp.appsdk.util;

import com.artsoft.examapp.appsdk.lesson.Lesson;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LessonUtil {

    Random random;

    public LessonUtil(){
        random = new Random();
    }

    private float netCalculate(Lesson lesson){
        float decrease = (float)lesson.baseVariable().getFalseQuantity() / SystemConstant.FALSE_FOR_NET;
        return lesson.baseVariable().getTrueQuantity() - decrease;
    }

    private Lesson assignToVariables(Lesson lesson){
        lesson.baseVariable().setTrueQuantity(random.nextInt(lesson.baseVariable().getQuestionQuantity()+1));
        lesson.baseVariable().setFalseQuantity(random.nextInt(lesson.baseVariable().getQuestionQuantity()-lesson.baseVariable().getTrueQuantity()+1));
        lesson.baseVariable().setNullQuantity(lesson.baseVariable().getQuestionQuantity()-lesson.baseVariable().getTrueQuantity()-lesson.baseVariable().getFalseQuantity());
        lesson.baseVariable().setNetQuantity(netCalculate(lesson));
        return lesson;
    }

    public List<Lesson> lessonCreate(List<Lesson> lessonList){
        lessonList.stream().forEach(
                lesson -> {
                    assignToVariables(lesson);
                }
        );
        return lessonList;
    }

    public List<Lesson> lessonCreate(Lesson... lessons){
        List<Lesson> lessonList = Arrays.asList(lessons);
        lessonList.stream().forEach(
                lesson -> {
                    assignToVariables(lesson);
                }
        );
        return lessonList;
    }
}
