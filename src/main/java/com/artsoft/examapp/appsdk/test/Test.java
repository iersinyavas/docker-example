package com.artsoft.examapp.appsdk.test;

import com.artsoft.examapp.appsdk.lesson.Lesson;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Test {

    String testName;
    Map<String, List<Lesson>> lessonMap;

}
