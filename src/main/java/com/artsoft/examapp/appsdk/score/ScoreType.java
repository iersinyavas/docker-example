package com.artsoft.examapp.appsdk.score;

import com.artsoft.examapp.appsdk.lesson.Lesson;

public interface ScoreType {

    Float scoreCalculate(Lesson lesson);
    Float scoreTypeCoefficient(Lesson lesson);
}
