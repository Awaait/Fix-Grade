package com.manage.grade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class GradeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GradeApplication.class, args);
    }

}
