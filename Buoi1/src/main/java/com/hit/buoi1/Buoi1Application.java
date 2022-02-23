package com.hit.buoi1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Buoi1Application {

    public static void main(String[] args) {
        SpringApplication.run(Buoi1Application.class, args);
        Integer a = 1000;
        Integer b = 1000;
        System.out.println(a==b);
    }

}
