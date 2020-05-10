package com.artsoft.examapp.appsdk.score;

import com.artsoft.examapp.appsdk.lesson.Lesson;
import com.artsoft.examapp.appsdk.util.LessonCoefficient;
import org.springframework.beans.factory.annotation.Autowired;

public class EqualFocusScore implements ScoreType {

    @Autowired
    LessonCoefficient lessonCoefficient;

    @Override
    public Float scoreCalculate(Lesson lesson) {
        return lesson.baseVariable().getNetQuantity() * scoreTypeCoefficient(lesson);
    }

    @Override
    public Float scoreTypeCoefficient(Lesson lesson) {
        return lessonCoefficient.getLessonEqualFocusScoreCoefficient().get(lesson.baseVariable().getLessonName());
    }
}
