package com.hit.buoi4_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @Value("${abc.v2}")
    private String appName;

    @GetMapping
    public String getStrings() {
        return appName;
    }

    //2 string ===
    @GetMapping("/{id}")
    public String getID1(@PathVariable("id") String id) {
        return id;
    }

    @GetMapping("/{id}/{username}")
    public String getID2(
            @PathVariable("id") Long id,
            @PathVariable("username") String username
    ) {
        //xuat ra man hinh
        return String.valueOf(id) + " - " + username;
    }

    //required: true - bắt buộc phải có param
    //Mặc định là true
    @GetMapping("/app")
    public String getParam1(
            @RequestParam(value = "name") String name,
            @RequestParam(value = "name2", required = false) String name2
    ) {
        return name + " - " + name2;
    }



}
