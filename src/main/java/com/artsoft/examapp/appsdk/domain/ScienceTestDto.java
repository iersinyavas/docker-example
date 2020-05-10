package com.artsoft.examapp.appsdk.domain;

import com.artsoft.examapp.appsdk.lesson.Biology;
import com.artsoft.examapp.appsdk.lesson.Chemistry;
import com.artsoft.examapp.appsdk.lesson.Physics;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScienceTestDto {
    Physics physics;
    Chemistry chemistry;
    Biology biology;

}
