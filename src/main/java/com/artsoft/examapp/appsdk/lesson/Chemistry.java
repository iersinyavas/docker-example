package com.artsoft.examapp.appsdk.lesson;

import com.artsoft.examapp.appsdk.score.ScoreType;
import com.artsoft.examapp.appsdk.util.BaseVariable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chemistry implements Lesson {

    BaseVariable baseVariable;

    @Override
    public float scoreTypeCoefficient(ScoreType scoreType) {
        return scoreType.scoreTypeCoefficient(this);
    }

    @Override
    public BaseVariable baseVariable() {
        return this.baseVariable;
    }

}
