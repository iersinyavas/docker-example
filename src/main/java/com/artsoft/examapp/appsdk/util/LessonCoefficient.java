package com.artsoft.examapp.appsdk.util;

import lombok.Data;

import java.util.Map;

@Data
public class LessonCoefficient {

   Map<String, Float> lessonDigitalScoreCoefficientMap;
   Map<String, Float> lessonVerbalScoreCoefficientMap;
   Map<String, Float> lessonEqualFocusScoreCoefficient;
   Map<String, Float> lessonForeignLanguageCoefficient;

   public LessonCoefficient(){}

    public LessonCoefficient(Map<String, Float> digital, Map<String, Float> verbal, Map<String, Float> equalFocus, Map<String, Float> foreignLanguage){
        this.lessonDigitalScoreCoefficientMap = digital;
        this.lessonVerbalScoreCoefficientMap = verbal;
        this.lessonEqualFocusScoreCoefficient = equalFocus;
        this.lessonForeignLanguageCoefficient = foreignLanguage;
    }


}
