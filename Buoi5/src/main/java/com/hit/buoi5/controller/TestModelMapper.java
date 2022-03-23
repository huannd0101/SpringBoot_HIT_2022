package com.hit.buoi5.controller;

import com.hit.buoi5.dto.UserDTO;
import com.hit.buoi5.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestModelMapper {
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<?> getData(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setUsername("123123123123123123");

        user = modelMapper.map(userDTO, User.class);

        System.out.println(user.getUsername());
        return ResponseEntity.status(200).body(user);
    }
}
