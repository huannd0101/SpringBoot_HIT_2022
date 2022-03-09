package com.hit.buoi4_2.controllers;

import com.hit.buoi4_2.dto.UserDTO;
import com.hit.buoi4_2.model.User;
import com.hit.buoi4_2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<?> getAllUser() {
        List<User> users = userRepository.findAll();

        return ResponseEntity.status(200).body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if(optionalUser.isEmpty()) {
            //throw exception
            return ResponseEntity.status(200).body("Không tìm thấy");
        }

        return ResponseEntity.status(200).body(optionalUser.get());
    }

    @PostMapping
    public String createNewUser(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setFullName(userDTO.getFullName());

        userRepository.save(user);

        return "Tạo thành công";
    }

}
