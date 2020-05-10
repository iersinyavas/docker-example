package com.artsoft.examapp.appsdk.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseVariable {
    private String lessonName;
    private int trueQuantity;
    private int falseQuantity;
    private int nullQuantity;
    private float netQuantity;
    private int questionQuantity;
}
