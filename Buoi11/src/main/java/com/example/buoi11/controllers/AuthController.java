package com.example.buoi11.controllers;

import com.example.buoi11.daos.Role;
import com.example.buoi11.daos.User;
import com.example.buoi11.dtos.UserDTO;
import com.example.buoi11.exceptions.BadRequestException;
import com.example.buoi11.filters.AuthenticationResponse;
import com.example.buoi11.payloads.AuthenticationRequest;
import com.example.buoi11.repositories.RoleRepository;
import com.example.buoi11.repositories.UserRepository;
import com.example.buoi11.services.MyUserDetailService;
import com.example.buoi11.utils.Convert;
import com.example.buoi11.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/v1/auths")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private MyUserDetailService myUserDetailService;

    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody UserDTO userDTO){
        User oldUser = userRepository.findByUsername(userDTO.getUsername());
        if (oldUser != null){
            throw new BadRequestException("User already exists");
        }
        User user = new User();
        Convert.fromUserDTOToUser(userDTO,user);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        Role role = roleRepository.findByNameRole("ROLE_USER");
        user.setRoles(Set.of(role));
        User user1 = userRepository.save(user);
        final UserDetails userDetails = myUserDetailService.loadUserByUsername(user1.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt,
                user1.getIdUser(),
                user1.getUsername(),
                List.of(role.getNameRole())));
    }

    public ResponseEntity<?> signIn(@RequestBody AuthenticationRequest authenticationRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    authenticationRequest.getUsername(),authenticationRequest.getPassword()
            ));
        }catch (BadCredentialsException e) {
            throw new BadRequestException("No username or password");
        }
        final UserDetails userDetails = myUserDetailService.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        User user = userRepository.findByUsername(authenticationRequest.getUsername());
        List<String> roles = new ArrayList<>();
        Set<Role> roleSet = user.getRoles();
        if (roleSet.size() > 0){
            roleSet.forEach(item -> roles.add(item.getNameRole()));
        }
        return ResponseEntity.ok(new AuthenticationResponse(jwt,user.getIdUser(),user.getUsername(),roles));
    }

}
