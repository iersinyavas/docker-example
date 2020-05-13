package com.artsoft.examapp.appsdk.domain;

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
public class Result{
    Integer resultId;
    Map<String, ExamDto> examDtoList;
    Float digitalScore;
    Float equalFocusScore;
    Float verbalScore;
    Float foreignLanguageScore;
}
