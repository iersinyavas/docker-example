package com.artsoft.examapp.appsdk.score;

import com.artsoft.examapp.appsdk.lesson.Lesson;

public class DigitalScore implements ScoreType {

    @Override
    public Float scoreCalculate(Lesson lesson) {
        return lesson.gNet() * lesson.digitalCoefficient();
    }
}