package com.artsoft.examapp.appsdk.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@EnableScheduling
@Configuration
@Service
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SchedulerConfig {

    @Autowired
    SimpMessagingTemplate template;

    int hiz=0;
    int yol=0;
    int ivme=0;
    Random random = new Random();
    Info info = new Info();

    @Scheduled(fixedDelay = 1000)
    public void sendAdhocMessages() {
        int x = random.nextInt(3);
        if (x == 2){
            if(this.getIvme() <= 5) {
                this.setIvme(this.getIvme() + 1);
                this.ilerle(this.getIvme());
                this.alinanYol(this.getHiz());
                info.setHiz(this.getHiz());
                info.setIvme(this.getIvme());
                info.setYol(this.getYol());
            }
        }else if(x == 1){
            this.ilerle(this.getIvme());
            this.alinanYol(this.getHiz());
            info.setHiz(this.getHiz());
            info.setIvme(this.getIvme());
            info.setYol(this.getYol());
        }
        else {
            if(this.getIvme() >= -5) {
                this.setIvme(this.getIvme() - 1);
                this.ilerle(this.getIvme());
                this.alinanYol(this.getHiz());
                info.setHiz(this.getHiz());
                info.setIvme(this.getIvme());
                info.setYol(this.getYol());
            }
        }
        template.convertAndSend("/topic/user", info);
    }

    public int ilerle(int artma){
        hiz += artma;
        return hiz;
    }

    public int alinanYol(int hiz){
        yol += hiz;
        return yol;
    }

}