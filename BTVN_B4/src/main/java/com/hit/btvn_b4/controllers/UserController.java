package com.hit.btvn_b4.controllers;

import com.hit.btvn_b4.dto.UserDTO;
import com.hit.btvn_b4.models.User;
import com.hit.btvn_b4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserAPIController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<?> getAllUser() {
        List<User> users = userRepository.findAll();
        return ResponseEntity.status(200).body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable(name = "id") Long id) {
        Optional<User> user = userRepository.findById(id);
        return ResponseEntity.status(200).body(user.get());
    }

    @PostMapping
    public ResponseEntity<?> createNewUser(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setFullName(userDTO.getFullName());

        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("Đã tạo thành công");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> editUserById(
            @PathVariable("id") Long id,
            @RequestBody UserDTO userDTO
    ) {
        User user = userRepository.getById(id);
        user.setFullName(userDTO.getFullName());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());

        //save lại
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.OK).body("Đã sửa thành công");
    }

}
