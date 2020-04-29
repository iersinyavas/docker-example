package com.artsoft.examapp.appsdk.domain;

import com.artsoft.examapp.appsdk.lesson.Lesson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultScore {
    List<Lesson> lessonList;
    Float digitalScore;
    Float equalFocusScore;
    Float verbalScore;
}
