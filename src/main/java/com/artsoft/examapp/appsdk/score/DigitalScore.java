package com.artsoft.examapp.appsdk.score;

import com.artsoft.examapp.appsdk.lesson.Lesson;
import com.artsoft.examapp.appsdk.util.LessonCoefficience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class DigitalScore implements ScoreType {

    @Autowired
    LessonCoefficience lessonCoefficience;

    @Override
    public Float scoreCalculate(Lesson lesson) {
        return lesson.gNet() * scoreTypeCoefficient(lesson);
    }

    @Override
    public Float scoreTypeCoefficient(Lesson lesson) {
        return lessonCoefficience.getLessonDigitalScoreCoefficientMap().get(lesson.gLessonName());
    }

}
