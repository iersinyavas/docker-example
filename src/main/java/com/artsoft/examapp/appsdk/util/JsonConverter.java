package com.artsoft.examapp.appsdk.util;

import com.artsoft.examapp.appsdk.domain.Result;
import com.artsoft.examapp.appsdk.domain.ResultScore;
import com.artsoft.examapp.appsdk.lesson.*;
import com.artsoft.examapp.appsdk.lesson.Math;
import com.artsoft.examapp.appsdk.score.DigitalScore;
import com.artsoft.examapp.appsdk.score.EqualFocusScore;
import com.artsoft.examapp.appsdk.score.VerbalScore;
import com.artsoft.examapp.appsdk.domain.StudentDto;
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

    @Autowired
    ScoreUtil scoreUtil;

    @Autowired
    DigitalScore digitalScore;

    @Autowired
    VerbalScore verbalScore;

    @Autowired
    EqualFocusScore equalFocusScore;

    private Result resultCreate(Stream<Lesson> lessonStream){
        ResultScore resultScore = new ResultScore();

        resultScore.setLessonList(lessonUtil.lessonCreate(lessonStream.collect(Collectors.toList())));
        resultScore.setDigitalScore(scoreUtil.scoreCalculate(digitalScore, resultScore.getLessonList())+SystemConstant.BASE_SCORE);
        resultScore.setEqualFocusScore(scoreUtil.scoreCalculate(verbalScore, resultScore.getLessonList())+SystemConstant.BASE_SCORE);
        resultScore.setVerbalScore(scoreUtil.scoreCalculate(equalFocusScore, resultScore.getLessonList())+SystemConstant.BASE_SCORE);

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

        return result;
    }

    public String studentCreate(Stream<Lesson> lessonStream){
        String studentString = null;
        StudentDto studentDto = new StudentDto();
        try {
            studentDto.setResult(this.resultCreate(lessonStream));
            studentString = objectMapper.writeValueAsString(studentDto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return studentString;
    }
}
