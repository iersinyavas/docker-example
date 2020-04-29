package com.artsoft.examapp.appsdk.util;

public enum LessonEnum {

    TURKISH(2, 3, 3, 40),
    MATH(4, 2, 3, 40),
    SCIENCE(3, 1, 2, 40),
    SOCIAL(1, 4, 2, 40);

    public float digitalCoefficient;
    public float verbalCoefficient;
    public float equalFocusCoefficient;
    public int questionQuantity;

    LessonEnum(float digitalCoefficient, float verbalCoefficient, float equalFocusCoefficient, int questionQuantity){
        this.digitalCoefficient = digitalCoefficient;
        this.verbalCoefficient = verbalCoefficient;
        this.equalFocusCoefficient = equalFocusCoefficient;
        this.questionQuantity = questionQuantity;
    }

}
