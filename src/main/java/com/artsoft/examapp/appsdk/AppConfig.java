package com.artsoft.examapp.appsdk;

import com.artsoft.examapp.appsdk.score.DigitalScore;
import com.artsoft.examapp.appsdk.score.EqualFocusScore;
import com.artsoft.examapp.appsdk.score.VerbalScore;
import com.artsoft.examapp.appsdk.util.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig {

    @Bean
    public JsonConverter jsonConverter(){
        return new JsonConverter();
    }

    @Bean
    public LessonUtil lessonUtil(){
        return new LessonUtil();
    }

    @Bean
    public ScoreUtil scoreUtil(){
        return new ScoreUtil();
    }

    @Bean
    public LessonCoefficience lessonCoefficience(){

        /*Map<String, Float> lessonDigitalScoreCoefficientMap = new HashMap<>();
        Map<String, Float> lessonVerbalScoreCoefficientMap = new HashMap<>();
        Map<String, Float> lessonEqualFocusScoreCoefficient = new HashMap<>();

        lessonDigitalScoreCoefficientMap.put("Matematik", LessonEnum.MATH.digitalCoefficient);
        lessonDigitalScoreCoefficientMap.put("Türkçe", LessonEnum.TURKISH.digitalCoefficient);
        lessonDigitalScoreCoefficientMap.put("Fen", LessonEnum.SCIENCE.digitalCoefficient);
        lessonDigitalScoreCoefficientMap.put("Sosyal", LessonEnum.SOCIAL.digitalCoefficient);

        lessonVerbalScoreCoefficientMap.put("Matematik", LessonEnum.MATH.verbalCoefficient);
        lessonVerbalScoreCoefficientMap.put("Türkçe", LessonEnum.TURKISH.verbalCoefficient);
        lessonVerbalScoreCoefficientMap.put("Fen", LessonEnum.SCIENCE.verbalCoefficient);
        lessonVerbalScoreCoefficientMap.put("Sosyal", LessonEnum.SOCIAL.verbalCoefficient);

        lessonEqualFocusScoreCoefficient.put("Matematik", LessonEnum.MATH.equalFocusCoefficient);
        lessonEqualFocusScoreCoefficient.put("Türkçe", LessonEnum.TURKISH.equalFocusCoefficient);
        lessonEqualFocusScoreCoefficient.put("Fen", LessonEnum.SCIENCE.equalFocusCoefficient);
        lessonEqualFocusScoreCoefficient.put("Sosyal", LessonEnum.SOCIAL.equalFocusCoefficient);

        return new LessonCoefficience(lessonDigitalScoreCoefficientMap, lessonVerbalScoreCoefficientMap, lessonEqualFocusScoreCoefficient);
    */
        return new LessonCoefficience();
    }

    @Bean
    public DigitalScore digitalScore(){
        return new DigitalScore();
    }

    @Bean
    public VerbalScore verbalScore(){
        return new VerbalScore();
    }

    @Bean
    public EqualFocusScore equalFocusScore(){
        return new EqualFocusScore();
    }
}
