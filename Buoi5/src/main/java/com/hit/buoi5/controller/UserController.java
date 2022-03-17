package com.hit.buoi5.controller;

import com.hit.buoi5.dto.UserDTO;
import com.hit.buoi5.exception.DuplicateException;
import com.hit.buoi5.exception.NotFoundException;
import com.hit.buoi5.model.Address;
import com.hit.buoi5.model.User;
import com.hit.buoi5.repository.UserRepository;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    UserRepository userRepository;

    /*
        GET	    : /api/v1/users
        GET	    : /api/v1/users/{id}
        POST	: /api/v1/users
        PATCH	: /api/v1/users/{id}
        DELETE	: /api/v1/users/{id}
    */

    @GetMapping
    public ResponseEntity<?> getAllUser(@RequestParam(value = "page", required = false) Integer page) {
        List<User> users;
        if(page == null) {
            users = userRepository.findAll(Sort.by("username").ascending());
        } else {
            users = userRepository.findAll(PageRequest.of(page, 3, Sort.by("id").descending())).getContent();
//            System.out.println(userRepository.findAll(PageRequest.of(page, 3)).getTotalPages()); //get total page
        }

        return ResponseEntity.status(200).body(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long id) {
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()) {
            throw new NotFoundException("Không tìm thấy user id: " + id);
        }

        return ResponseEntity.status(HttpStatus.OK).body(user.get());
    }

    @PostMapping
    public ResponseEntity<?> createNewUser(@RequestBody UserDTO userDTO) {
        User user = userRepository.findByUsername(userDTO.getUsername());

        if(user != null) {
            throw new DuplicateException("Username đã tồn tại");
        }

        user = new User(userDTO.getUsername(), userDTO.getPassword(), userDTO.getFullName());

        return ResponseEntity.status(201).body(userRepository.save(user));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> editUserById(
            @PathVariable("id") Long id,
            @RequestBody UserDTO userDTO
    ) {
        Optional<User> optionalUser = userRepository.findById(id);

        if(optionalUser.isEmpty()) {
            throw new NotFoundException("Không tìm thấy user id: " + id);
        }

        User user = optionalUser.get();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setFullName(userDTO.getFullName());

        return ResponseEntity.status(201).body(userRepository.save(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if(optionalUser.isEmpty()) {
            throw new NotFoundException("Không tìm thấy user id: " + id);
        }

        userRepository.deleteById(id);

        return ResponseEntity.status(200).body("Xóa thành công");
    }

    @GetMapping("/{id}/addresses")
    public ResponseEntity<?> getAllAddressById(@PathVariable("id") Long id) {
        List<Address> addresses = userRepository.findById(id).get().getAddresses();
        return ResponseEntity.status(200).body(
                addresses
        );
    }

}
