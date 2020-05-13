package com.artsoft.examapp.appsdk.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class Info {
    int hiz;
    int yol;
    int ivme;

    public Info(int hiz, int yol, int ivme){
        this.hiz = hiz;
        this.yol = yol;
        this.ivme = ivme;
    }
}
