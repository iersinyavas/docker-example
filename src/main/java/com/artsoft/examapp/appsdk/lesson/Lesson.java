package com.artsoft.examapp.appsdk.lesson;

//@JsonDeserialize(using = LessonDeserializer.class) interface nin json için serileştirilmesinde kullanılıyor araştır.

public interface Lesson {
    float digitalCoefficient();
    float verbalCoefficient();
    float equalFocusCoefficient();
    int questionQuantity();
    int gTrue();
    int gFalse();
    int gNull();
    float gNet();
    void sTrue(int trueQuantity);
    void sFalse(int falseQuantity);
    void sNull(int nullQuantity);
    void sNet(float netQuantity);
    String gLessonName();
    void sLessonName(String lessonName);
}
