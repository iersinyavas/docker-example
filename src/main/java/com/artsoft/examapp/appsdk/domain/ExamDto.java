package com.artsoft.examapp.appsdk.domain;

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
public class ExamDto {
    TurkishTestDto turkishTestDto;
    MathTestDto mathTestDto;
    SocialTestDto socialTestDto;
    ScienceTestDto scienceTestDto;
}
