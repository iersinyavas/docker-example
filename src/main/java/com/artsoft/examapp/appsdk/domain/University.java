package com.artsoft.examapp.appsdk.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class University {
    Integer universityId;
    String universityName;
    Integer quality;
    Integer capacity;
    Integer activeCapacity;
}
