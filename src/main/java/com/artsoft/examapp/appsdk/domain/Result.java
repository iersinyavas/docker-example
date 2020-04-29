package com.artsoft.examapp.appsdk.domain;

import com.artsoft.examapp.appsdk.lesson.Math;
import com.artsoft.examapp.appsdk.lesson.Science;
import com.artsoft.examapp.appsdk.lesson.Social;
import com.artsoft.examapp.appsdk.lesson.Turkish;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    Turkish turkish;
    Math math;
    Science science;
    Social social;
    Float digitalScore;
    Float equalFocusScore;
    Float verbalScore;
}
