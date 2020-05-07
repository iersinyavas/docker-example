package com.artsoft.examapp.appsdk.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class University {
    Integer universityId;
    String universityName;
    Integer quality;
    Integer capacity;
    Integer activeCapacity;
}
