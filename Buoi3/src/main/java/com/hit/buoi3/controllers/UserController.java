package com.hit.buoi3.controllers;

import com.hit.buoi3.models.Res;
import com.hit.buoi3.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//@Controller
//@ResponseBody
@RequestMapping("/api/v1/users")
public class UserController {
//
//    @GetMapping("index")
//    public String getIndexPage() {
//        return "index";
//    }

//    @GetMapping
//    public List<User> getUser() {
////        User user = new User(1, "huannd0101", "123");
//        List<User> users = new ArrayList<>();
//        users.add(new User(1, "huannd0101", "123234"));
//        users.add(new User(2, "huannd01016", "123"));
//        users.add(new User(3, "huannd01015", "132342423"));
//        users.add(new User(4, "huannd0101845234", "123"));
//        users.add(new User(5, "huannd01071", "123"));
////        return ResponseEntity.status(200).body(user);
//        return users;
//    }


    @GetMapping("")
    public ResponseEntity<?> getListUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "huannd0101", "123234"));
        users.add(new User(2, "huannd01016", "123"));
        users.add(new User(3, "huannd01015", "132342423"));
        users.add(new User(4, "huannd0101845234", "123"));
        users.add(new User(5, "huannd01071", "123"));

        Res res = new Res("Success", users);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    //Tạo dữ liệu - gửi dữ liệu quan trọng
    @PostMapping("")
    public ResponseEntity<?> postMethod(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.OK).body(user.getUsername());
    }

    //Sửa dữ liệu
    @PatchMapping()
    public ResponseEntity<?> patchMethod() {
        return ResponseEntity.status(HttpStatus.OK).body("Đây là method patch");
    }

    //Sửa dữ liệu - ít sử dụng
    @PutMapping()
    public ResponseEntity<?> putMethod() {
        return ResponseEntity.status(HttpStatus.OK).body("Đây là method put");
    }

    //xóa dữ liệu
    @DeleteMapping()
    public ResponseEntity<?> deleteMethod() {
        return ResponseEntity.status(HttpStatus.OK).body("Đây là method delete");
    }
}


