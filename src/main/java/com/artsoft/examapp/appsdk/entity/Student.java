package com.artsoft.examapp.appsdk.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Builder
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer studentId;

    @Column
    private Float digitalScore;

    @Column
    private Float equalFocusScore;

    @Column
    private Float verbalScore;
}
