package com.artsoft.examapp.appsdk;

import com.artsoft.examapp.appsdk.util.JsonConverter;
import com.artsoft.examapp.appsdk.util.LessonUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public JsonConverter jsonConverter(){
        return new JsonConverter();
    }

    @Bean
    public LessonUtil lessonUtil(){
        return new LessonUtil();
    }
}
