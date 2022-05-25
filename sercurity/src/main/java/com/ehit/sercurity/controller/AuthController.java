package com.ehit.sercurity.controller;

import com.ehit.sercurity.dto.AuthResponse;
import com.ehit.sercurity.dto.UserDto;
import com.ehit.sercurity.service.MyUserDetailService;
import com.ehit.sercurity.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthController {

  @Autowired
  private JwtUtil jwtUtil;

  @Autowired
  private MyUserDetailService myUserDetailService;

  @Autowired
  private AuthenticationManager authenticationManager;

  @PostMapping("/auth/login")
  public ResponseEntity<?> login(@RequestBody UserDto userDto) throws Exception {
    System.out.println(123);
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getUsername(),
          userDto.getPassword()));
    } catch (BadCredentialsException e) {
      throw new Exception("Incorrect username or password");
    }

    final UserDetails userDetails = myUserDetailService.loadUserByUsername(userDto.getUsername());
    final String jwt = jwtUtil.generateToken(userDetails);

    SecurityContextHolder.getContext()
        .setAuthentication(new UsernamePasswordAuthenticationToken(userDetails.getUsername(),
            userDetails.getPassword()));

    //check time pass
    return ResponseEntity.ok(new AuthResponse(jwt, userDetails.getUsername()));
  }

}
