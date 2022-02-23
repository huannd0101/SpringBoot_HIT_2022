package com.hit.buoi2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
//    public Bikini bikini = context.getBean(Bikini.class);
    @Autowired
    public Bikini bikini;

    public void wear() {
        System.out.println("Đang mặc....");
    }
}
