package com.hit.buoi9.service;

import com.hit.buoi9.dto.UserDTO;
import com.hit.buoi9.models.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    List<User> getAllUserByName(String name);
    User createNewUser(UserDTO userDTO);
}
