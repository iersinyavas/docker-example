package com.artsoft.examapp.appsdk.util;

import com.artsoft.examapp.appsdk.domain.*;
import com.artsoft.examapp.appsdk.exam.Exam;
import com.artsoft.examapp.appsdk.lesson.*;
import com.artsoft.examapp.appsdk.lesson.Math;
import com.artsoft.examapp.appsdk.score.DigitalScore;
import com.artsoft.examapp.appsdk.score.EqualFocusScore;
import com.artsoft.examapp.appsdk.score.ForeignLanguageScore;
import com.artsoft.examapp.appsdk.score.VerbalScore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

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

    @Autowired
    ForeignLanguageScore foreignLanguageScore;

    private Result resultCreate(Map<String, Exam> examMap){

        Result result = new Result();
        result.setDigitalScore(0f);
        result.setEqualFocusScore(0f);
        result.setVerbalScore(0f);
        examMap.entrySet().stream().forEach(
                exam -> exam.getValue().getTestMap().entrySet().stream().forEach(
                        testMap -> testMap.getValue().stream().forEach(
                                test -> test.getLessonMap().entrySet().stream().forEach(
                                        lessonMap -> {
                                            lessonUtil.lessonCreate(lessonMap.getValue());
                                            result.setDigitalScore(result.getDigitalScore()+scoreUtil.scoreCalculate(digitalScore, lessonMap.getValue()));
                                            result.setEqualFocusScore(result.getEqualFocusScore()+scoreUtil.scoreCalculate(equalFocusScore, lessonMap.getValue()));
                                            result.setVerbalScore(result.getVerbalScore()+scoreUtil.scoreCalculate(verbalScore, lessonMap.getValue()));
                                        }
                                )
                        )
                )
        );

        result.setDigitalScore(result.getDigitalScore()+SystemConstant.BASE_SCORE);
        result.setEqualFocusScore(result.getEqualFocusScore()+SystemConstant.BASE_SCORE);
        result.setVerbalScore(result.getVerbalScore()+SystemConstant.BASE_SCORE);

        Map<String, ExamDto> examDtoMap = new HashMap<>();

        ExamDto examDto = ExamDto.builder()
                .turkishTestDto(TurkishTestDto
                        .builder()
                        .turkish((Turkish) lessonExtract(examMap, "Türkçe"))
                        .grammar((Grammar) lessonExtract(examMap, "Dil Bilgisi"))
                        .build())
                .mathTestDto(MathTestDto
                        .builder()
                        .math((Math) lessonExtract(examMap, "Matematik"))
                        .geometry((Geometry) lessonExtract(examMap, "Geometri"))
                        .build())
                .scienceTestDto(ScienceTestDto
                        .builder()
                        .physics((Physics) lessonExtract(examMap, "Fizik"))
                        .chemistry((Chemistry) lessonExtract(examMap, "Kimya"))
                        .biology((Biology) lessonExtract(examMap, "Biyoloji"))
                        .build())
                .socialTestDto(SocialTestDto
                        .builder()
                        .geography((Geography) lessonExtract(examMap, "Coğrafya"))
                        .history((History) lessonExtract(examMap, "Tarih"))
                        .philosophy((Philosophy) lessonExtract(examMap, "Felsefe"))
                        .religionCulture((ReligionCulture) lessonExtract(examMap, "Din Kültürü"))
                        .build())
                .build();
        examDtoMap.put("YGS", examDto);

        result.setExamDtoList(examDtoMap);

        return result;
    }

    private Lesson lessonExtract(Map<String, Exam> examMap, String lessonName){
         AtomicReference<Lesson> lesson = new AtomicReference<>();
         examMap.entrySet().stream().forEach(
                exam -> exam.getValue().getTestMap().entrySet().stream().forEach(
                        testMap -> testMap.getValue().stream().forEach(
                                test -> test.getLessonMap().entrySet().stream().forEach(
                                        lessonMap -> lessonMap.getValue().stream().filter(lesson1 -> lesson1.baseVariable().getLessonName().equals(lessonName)).forEach(
                                                lesson1 -> {
                                                    lesson.set(lesson1);
                                                }
                                        )
                                )
                        )
                )
        );
         return lesson.get();
    }

    public StudentDto studentCreate1(Map<String, Exam> examMap){
        StudentDto studentDto = new StudentDto();
        studentDto.setResult(this.resultCreate(examMap));
        return studentDto;
    }

    public String studentCreate(Map<String, Exam> examMap){

        String studentString = null;
        StudentDto studentDto = new StudentDto();
        try {
            studentDto.setResult(this.resultCreate(examMap));
            studentString = objectMapper.writeValueAsString(studentDto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return studentString;
    }
}
