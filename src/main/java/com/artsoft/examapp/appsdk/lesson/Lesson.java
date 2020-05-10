package com.artsoft.examapp.appsdk.lesson;

//@JsonDeserialize(using = LessonDeserializer.class) interface nin json için serileştirilmesinde kullanılıyor araştır.

import com.artsoft.examapp.appsdk.score.ScoreType;
import com.artsoft.examapp.appsdk.util.BaseVariable;

public interface Lesson {

    float scoreTypeCoefficient(ScoreType scoreType);
    BaseVariable baseVariable();
}
