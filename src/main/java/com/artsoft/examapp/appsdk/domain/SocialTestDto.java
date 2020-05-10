package com.artsoft.examapp.appsdk.domain;

import com.artsoft.examapp.appsdk.lesson.Geography;
import com.artsoft.examapp.appsdk.lesson.History;
import com.artsoft.examapp.appsdk.lesson.Philosophy;
import com.artsoft.examapp.appsdk.lesson.ReligionCulture;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SocialTestDto {

    History history;
    Geography geography;
    Philosophy philosophy;
    ReligionCulture religionCulture;
}
