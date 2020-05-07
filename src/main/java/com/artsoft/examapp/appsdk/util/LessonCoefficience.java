package com.artsoft.examapp.appsdk.util;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Data
public class LessonCoefficience {

   Map<String, Float> lessonDigitalScoreCoefficientMap;
   Map<String, Float> lessonVerbalScoreCoefficientMap;
   Map<String, Float> lessonEqualFocusScoreCoefficient;

   public LessonCoefficience(){

       lessonDigitalScoreCoefficientMap = new HashMap<>();
       lessonVerbalScoreCoefficientMap = new HashMap<>();
       lessonEqualFocusScoreCoefficient = new HashMap<>();

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
   }
    public LessonCoefficience(Map<String, Float> digital, Map<String, Float> verbal, Map<String, Float> equalFocus){
        this.lessonDigitalScoreCoefficientMap = digital;
        this.lessonVerbalScoreCoefficientMap = verbal;
        this.lessonEqualFocusScoreCoefficient = equalFocus;
    }


}
