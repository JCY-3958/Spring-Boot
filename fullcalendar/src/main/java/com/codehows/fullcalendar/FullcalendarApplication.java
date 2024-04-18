package com.codehows.fullcalendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class FullcalendarApplication {

    public static void main(String[] args) {
        SpringApplication.run(FullcalendarApplication.class, args);
    }

}
