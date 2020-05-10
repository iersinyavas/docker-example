package com.artsoft.examapp.appsdk.util;

public enum LessonEnum {

    TURKISH(2, 3, 3),
    MATH(4, 2, 3),
    SCIENCE(3, 1, 2),
    SOCIAL(1, 4, 2);

/*    GRAMMAR(),

    GEOMETRY(),

    GEOGRAPHY(),
    HISTORY(),
    LITERATURE(),
    PHILOSOPHY(),
    RELIGIONCULTURE(),

    BIOLOGY(),
    CHEMISTRY(),
    PHYSICS();*/


    public float digitalCoefficient;
    public float verbalCoefficient;
    public float equalFocusCoefficient;

    LessonEnum(float digitalCoefficient, float verbalCoefficient, float equalFocusCoefficient){
        this.digitalCoefficient = digitalCoefficient;
        this.verbalCoefficient = verbalCoefficient;
        this.equalFocusCoefficient = equalFocusCoefficient;
    }

}
