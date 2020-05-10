package com.artsoft.examapp.appsdk.exam;

import com.artsoft.examapp.appsdk.test.Test;
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
public class Exam {

    String examName;
    Map<String, List<Test>> testMap;

}
