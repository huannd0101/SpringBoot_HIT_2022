package com.example.buoi10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScans({@ComponentScan("com.example.buoi10.controllers"),@ComponentScan("com.example.buoi10.configs")})
public class Buoi10Application {

    public static void main(String[] args) {
        SpringApplication.run(Buoi10Application.class, args);
    }

}
