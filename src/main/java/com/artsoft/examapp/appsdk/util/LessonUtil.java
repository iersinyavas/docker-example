package com.artsoft.examapp.appsdk.util;

import com.artsoft.examapp.appsdk.lesson.Lesson;

import java.util.List;
import java.util.Random;

public class LessonUtil {

    Random random;

    public LessonUtil(){
        random = new Random();
    }

    private float netCalculate(Lesson lesson){
        float decrease = (float)lesson.gFalse() / SystemConstant.FALSE_FOR_NET;
        return lesson.gTrue() - decrease;
    }

    private Lesson assignToVariables(Lesson lesson){
        lesson.sTrue(random.nextInt(lesson.questionQuantity()+1));
        lesson.sFalse(random.nextInt(lesson.questionQuantity()-lesson.gTrue()+1));
        lesson.sNull(lesson.questionQuantity()-lesson.gTrue()-lesson.gFalse());
        lesson.sNet(netCalculate(lesson));
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
}
