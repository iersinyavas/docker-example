package com.artsoft.examapp.appsdk.domain;

import com.artsoft.examapp.appsdk.lesson.Geometry;
import com.artsoft.examapp.appsdk.lesson.Math;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MathTestDto {
    Math math;
    Geometry geometry;
}
