package com.artsoft.examapp.appsdk.util;

public enum ForeignLanguageLesson {

    ENGLISH(1), GERMAN(1);

    float foreignLanguageCoefficient;
    ForeignLanguageLesson(float foreignLanguageCoefficient){
        this.foreignLanguageCoefficient = foreignLanguageCoefficient;
    }

}
