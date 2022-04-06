package com.hit.buoi6.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    @GetMapping
    public String getTitle() {
        return "HIT 12";
    }
}
