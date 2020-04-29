package com.artsoft.examapp.appsdk.util;

import com.artsoft.examapp.appsdk.domain.Result;
import com.artsoft.examapp.appsdk.domain.ResultScore;
import com.artsoft.examapp.appsdk.lesson.*;
import com.artsoft.examapp.appsdk.lesson.Math;
import com.artsoft.examapp.appsdk.score.DigitalScore;
import com.artsoft.examapp.appsdk.score.EqualFocusScore;
import com.artsoft.examapp.appsdk.score.VerbalScore;
import com.artsoft.examapp.appsdk.domain.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JsonConverter {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    LessonUtil lessonUtil;

    public String resultCreate(Stream<Lesson> lessonStream){
        ResultScore resultScore = new ResultScore();

        String resultString = null;
        resultScore.setLessonList(lessonUtil.lessonCreate(lessonStream.collect(Collectors.toList())));
        resultScore.setDigitalScore(ScoreUtil.scoreCalculate(new DigitalScore(), resultScore.getLessonList()));
        resultScore.setEqualFocusScore(ScoreUtil.scoreCalculate(new EqualFocusScore(), resultScore.getLessonList()));
        resultScore.setVerbalScore(ScoreUtil.scoreCalculate(new VerbalScore(), resultScore.getLessonList()));

        Result result = new Result();
        resultScore.getLessonList().stream().filter(lesson -> lesson.gLessonName().equals("Matematik")).forEach(
                lesson -> result.setMath((Math)lesson)
        );
        resultScore.getLessonList().stream().filter(lesson -> lesson.gLessonName().equals("Sosyal")).forEach(
                lesson -> result.setSocial((Social)lesson)
        );
        resultScore.getLessonList().stream().filter(lesson -> lesson.gLessonName().equals("Fen")).forEach(
                lesson -> result.setScience((Science) lesson)
        );
        resultScore.getLessonList().stream().filter(lesson -> lesson.gLessonName().equals("Türkçe")).forEach(
                lesson -> result.setTurkish((Turkish) lesson)
        );
        result.setDigitalScore(resultScore.getDigitalScore());
        result.setEqualFocusScore(resultScore.getEqualFocusScore());
        result.setVerbalScore(resultScore.getVerbalScore());
        try {
            resultString = objectMapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return resultString;
    }

    public Student student(){
        return null;
    }
}
