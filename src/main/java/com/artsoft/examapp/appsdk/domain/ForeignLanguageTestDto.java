package com.artsoft.examapp.appsdk.domain;

import com.artsoft.examapp.appsdk.lesson.English;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ForeignLanguageTestDto {
    English english;
}
