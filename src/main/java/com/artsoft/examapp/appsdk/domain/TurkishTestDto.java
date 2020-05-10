package com.artsoft.examapp.appsdk.domain;

import com.artsoft.examapp.appsdk.lesson.Grammar;
import com.artsoft.examapp.appsdk.lesson.Turkish;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TurkishTestDto {
    Turkish turkish;
    Grammar grammar;
}
