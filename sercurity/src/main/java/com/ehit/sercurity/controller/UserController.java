package com.ehit.sercurity.controller;

import com.ehit.sercurity.dto.UserDto;
import com.ehit.sercurity.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
//  private UserService userService;
  private final UserService userService; //Khởi tạo giá khi để final

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/api/users/get")
  public ResponseEntity<?> getAllUser() {
    return ResponseEntity.ok(userService.getAllUser());
  }

  @PreAuthorize("hasAuthority('ROLE_ADMIN')")
  @PostMapping("/api/users/create")
  public ResponseEntity<?> createNewUser(@RequestBody UserDto userDto) {
    return ResponseEntity.ok(userService.createNewUser(userDto));
  }

  @DeleteMapping("/api/users/delete")
  public ResponseEntity<?> deleteUserById(@RequestParam("id") Long id) {
    return ResponseEntity.ok(userService.deleteUserById(id));
  }

}
