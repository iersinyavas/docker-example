package com.artsoft.examapp.appsdk.lesson;

import com.artsoft.examapp.appsdk.score.ScoreType;
import com.artsoft.examapp.appsdk.util.BaseVariable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Social implements Lesson {

    @Autowired
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
