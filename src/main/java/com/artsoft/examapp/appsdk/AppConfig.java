package com.artsoft.examapp.appsdk;

import com.artsoft.examapp.appsdk.lesson.*;
import com.artsoft.examapp.appsdk.lesson.Math;
import com.artsoft.examapp.appsdk.score.DigitalScore;
import com.artsoft.examapp.appsdk.score.EqualFocusScore;
import com.artsoft.examapp.appsdk.score.ForeignLanguageScore;
import com.artsoft.examapp.appsdk.score.VerbalScore;
import com.artsoft.examapp.appsdk.util.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

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
    public ExamUtil examUtil(){ return new ExamUtil(); }

    @Bean
    public TestUtil testUtil(){ return new TestUtil(); }

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

    @Bean
    public ForeignLanguageScore foreignLanguageScore(){ return new ForeignLanguageScore(); }

    @Bean
    public LessonCoefficient lessonCoefficient(){

        Map<String, Float> lessonDigitalScoreCoefficientMap = new HashMap<>();
        Map<String, Float> lessonVerbalScoreCoefficientMap = new HashMap<>();
        Map<String, Float> lessonEqualFocusScoreCoefficient = new HashMap<>();
        Map<String, Float> lessonForeignLanguageCoefficient = new HashMap<>();

        lessonDigitalScoreCoefficientMap.put("Türkçe", LessonEnum.TURKISH.digitalCoefficient);
        lessonDigitalScoreCoefficientMap.put("Dil Bilgisi", LessonEnum.TURKISH.digitalCoefficient);

        lessonVerbalScoreCoefficientMap.put("Türkçe", LessonEnum.TURKISH.verbalCoefficient);
        lessonVerbalScoreCoefficientMap.put("Dil Bilgisi", LessonEnum.TURKISH.verbalCoefficient);

        lessonEqualFocusScoreCoefficient.put("Türkçe", LessonEnum.TURKISH.equalFocusCoefficient);
        lessonEqualFocusScoreCoefficient.put("Dil Bilgisi", LessonEnum.TURKISH.equalFocusCoefficient);

        ///////////////////////////////////////////////////////////////////////////////

        lessonDigitalScoreCoefficientMap.put("Matematik", LessonEnum.MATH.digitalCoefficient);
        lessonDigitalScoreCoefficientMap.put("Geometri", LessonEnum.MATH.digitalCoefficient);

        lessonVerbalScoreCoefficientMap.put("Matematik", LessonEnum.MATH.verbalCoefficient);
        lessonVerbalScoreCoefficientMap.put("Geometri", LessonEnum.MATH.verbalCoefficient);

        lessonEqualFocusScoreCoefficient.put("Matematik", LessonEnum.MATH.equalFocusCoefficient);
        lessonEqualFocusScoreCoefficient.put("Geometri", LessonEnum.MATH.equalFocusCoefficient);

        ///////////////////////////////////////////////////////////////////////////////////////

        lessonDigitalScoreCoefficientMap.put("Tarih", LessonEnum.SOCIAL.digitalCoefficient);
        lessonDigitalScoreCoefficientMap.put("Coğrafya", LessonEnum.SOCIAL.digitalCoefficient);
        lessonDigitalScoreCoefficientMap.put("Felsefe", LessonEnum.SOCIAL.digitalCoefficient);
        lessonDigitalScoreCoefficientMap.put("Din Kültürü", LessonEnum.SOCIAL.digitalCoefficient);

        lessonVerbalScoreCoefficientMap.put("Tarih", LessonEnum.SOCIAL.verbalCoefficient);
        lessonVerbalScoreCoefficientMap.put("Coğrafya", LessonEnum.SOCIAL.verbalCoefficient);
        lessonVerbalScoreCoefficientMap.put("Felsefe", LessonEnum.SOCIAL.verbalCoefficient);
        lessonVerbalScoreCoefficientMap.put("Din Kültürü", LessonEnum.SOCIAL.verbalCoefficient);

        lessonEqualFocusScoreCoefficient.put("Tarih", LessonEnum.SOCIAL.equalFocusCoefficient);
        lessonEqualFocusScoreCoefficient.put("Coğrafya", LessonEnum.SOCIAL.equalFocusCoefficient);
        lessonEqualFocusScoreCoefficient.put("Felsefe", LessonEnum.SOCIAL.equalFocusCoefficient);
        lessonEqualFocusScoreCoefficient.put("Din Kültürü", LessonEnum.SOCIAL.equalFocusCoefficient);

        //////////////////////////////////////////////////////////////////////////////////////

        lessonDigitalScoreCoefficientMap.put("Biyoloji", LessonEnum.SCIENCE.digitalCoefficient);
        lessonDigitalScoreCoefficientMap.put("Fizik", LessonEnum.SCIENCE.digitalCoefficient);
        lessonDigitalScoreCoefficientMap.put("Kimya", LessonEnum.SCIENCE.digitalCoefficient);

        lessonVerbalScoreCoefficientMap.put("Biyoloji", LessonEnum.SCIENCE.verbalCoefficient);
        lessonVerbalScoreCoefficientMap.put("Fizik", LessonEnum.SCIENCE.verbalCoefficient);
        lessonVerbalScoreCoefficientMap.put("Kimya", LessonEnum.SCIENCE.verbalCoefficient);

        lessonEqualFocusScoreCoefficient.put("Biyoloji", LessonEnum.SCIENCE.equalFocusCoefficient);
        lessonEqualFocusScoreCoefficient.put("Fizik", LessonEnum.SCIENCE.equalFocusCoefficient);
        lessonEqualFocusScoreCoefficient.put("Kimya", LessonEnum.SCIENCE.equalFocusCoefficient);

        return new LessonCoefficient(lessonDigitalScoreCoefficientMap, lessonVerbalScoreCoefficientMap, lessonEqualFocusScoreCoefficient, lessonForeignLanguageCoefficient);
    }

    @Bean
    public LessonConfig lessonConfig(){

        Map<String, List<Lesson>> testMap = new HashMap<>();

        testMap.put("Türkçe", Arrays.asList(
                Turkish.builder().baseVariable(BaseVariable.builder().lessonName("Türkçe").questionQuantity(34).build()).build(),
                Grammar.builder().baseVariable(BaseVariable.builder().lessonName("Dil Bilgisi").questionQuantity(6).build()).build()
        ));

        testMap.put("Matematik", Arrays.asList(
                Math.builder().baseVariable(BaseVariable.builder().lessonName("Matematik").questionQuantity(32).build()).build(),
                Geometry.builder().baseVariable(BaseVariable.builder().lessonName("Geometri").questionQuantity(8).build()).build()
        ));

        testMap.put("Sosyal", Arrays.asList(
                History.builder().baseVariable(BaseVariable.builder().lessonName("Tarih").questionQuantity(15).build()).build(),
                Geography.builder().baseVariable(BaseVariable.builder().lessonName("Coğrafya").questionQuantity(12).build()).build(),
                Philosophy.builder().baseVariable(BaseVariable.builder().lessonName("Felsefe").questionQuantity(8).build()).build(),
                ReligionCulture.builder().baseVariable(BaseVariable.builder().lessonName("Din Kültürü").questionQuantity(5).build()).build()
        ));

        testMap.put("Fen", Arrays.asList(
                Physics.builder().baseVariable(BaseVariable.builder().lessonName("Fizik").questionQuantity(14).build()).build(),
                Chemistry.builder().baseVariable(BaseVariable.builder().lessonName("Kimya").questionQuantity(13).build()).build(),
                Biology.builder().baseVariable(BaseVariable.builder().lessonName("Biyoloji").questionQuantity(13).build()).build()
        ));
        return new LessonConfig(testMap);
    }
}
