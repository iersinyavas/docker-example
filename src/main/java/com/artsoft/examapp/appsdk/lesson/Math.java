package com.artsoft.examapp.appsdk.lesson;

import com.artsoft.examapp.appsdk.score.ScoreType;
import com.artsoft.examapp.appsdk.util.BaseVariable;
import com.artsoft.examapp.appsdk.util.LessonEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@JsonDeserialize(as = Math.class) interface nin json için serileştirilmesinde kullanılıyor araştır.
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Math implements Lesson {

    BaseVariable baseVariable;

    @Override
    public float scoreTypeCoefficient(ScoreType scoreType) {
        return scoreType.scoreTypeCoefficient(this);
    }

    @Override
    public int questionQuantity() {
        return LessonEnum.MATH.questionQuantity;
    }

    @Override
    public int gTrue() {
        return baseVariable.getTrueQuantity();
    }

    @Override
    public int gFalse() {
        return baseVariable.getFalseQuantity();
    }

    @Override
    public int gNull() {
        return baseVariable.getNullQuantity();
    }

    @Override
    public float gNet() {
        return baseVariable.getNetQuantity();
    }

    @Override
    public void sTrue(int trueQuantity) {
        this.baseVariable.setTrueQuantity(trueQuantity);
    }

    @Override
    public void sFalse(int falseQuantity) {
        this.baseVariable.setFalseQuantity(falseQuantity);
    }

    @Override
    public void sNull(int nullQuantity) {
        this.baseVariable.setNullQuantity(nullQuantity);
    }

    @Override
    public void sNet(float netQuantity) {
        this.baseVariable.setNetQuantity(netQuantity);
    }

    @Override
    public String gLessonName() {
        return baseVariable.getLessonName();
    }

    @Override
    public void sLessonName(String lessonName) {
        this.baseVariable.setLessonName(lessonName);
    }

}
