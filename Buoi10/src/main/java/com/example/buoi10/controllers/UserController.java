package com.example.buoi10.controllers;

import com.example.buoi10.daos.User;
import com.example.buoi10.dtos.UserDTO;
import com.example.buoi10.repositories.UserRepository;
import com.example.buoi10.services.ISendMailService;
import com.example.buoi10.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ISendMailService sendMailService;

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO userDTO){
        User user = new User();
        Convert.fromUserDTOToUser(userDTO,user);
        sendMailService.sendMailWithText("Hello","Đây là lời chào từ Sáng đẹp trai",userDTO.getEmail());
        return ResponseEntity.status(201).body(userRepository.save(user));
    }
    @GetMapping("/deny")
    public ResponseEntity<?> getStringDeny(){
        return ResponseEntity.status(200).body("Co tk moi dc vao ");
    }

    @GetMapping("/admit")
    public ResponseEntity<?> getStringAdmit(){
        return ResponseEntity.status(200).body("Ai cung duoc vao");
    }


}
