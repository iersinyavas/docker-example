package com.artsoft.examapp.appsdk.lesson;

import com.artsoft.examapp.appsdk.score.ScoreType;
import com.artsoft.examapp.appsdk.util.LessonEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Social implements Lesson {

    private String lessonName;
    private int trueQuantity;
    private int falseQuantity;
    private int nullQuantity;
    private float netQuantity;

    @Override
    public float scoreTypeCoefficient(ScoreType scoreType) {
        return scoreType.scoreTypeCoefficient(this);
    }

    @Override
    public int questionQuantity() {
        return LessonEnum.SOCIAL.questionQuantity;
    }

    @Override
    public int gTrue() {
        return trueQuantity;
    }

    @Override
    public int gFalse() {
        return falseQuantity;
    }

    @Override
    public int gNull() {
        return nullQuantity;
    }

    @Override
    public float gNet() {
        return netQuantity;
    }

    @Override
    public void sTrue(int trueQuantity) {
        this.trueQuantity = trueQuantity;
    }

    @Override
    public void sFalse(int falseQuantity) {
        this.falseQuantity = falseQuantity;
    }

    @Override
    public void sNull(int nullQuantity) {
        this.nullQuantity = nullQuantity;
    }

    @Override
    public void sNet(float netQuantity) {
        this.netQuantity = netQuantity;
    }

    @Override
    public String gLessonName() {
        return lessonName;
    }

    @Override
    public void sLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

}
