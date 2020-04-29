package com.artsoft.examapp.appsdk.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    Integer studentId;
    Result result;
    Preference preference;
}
