package com.example.buoi11.utils;

import com.example.buoi11.daos.User;
import com.example.buoi11.dtos.UserDTO;

public class Convert {
    public static User fromUserDTOToUser(UserDTO userDTO,User user){
        if (userDTO.getName() != null){
            user.setName(userDTO.getName());
        }
        if (userDTO.getUsername() != null){
            user.setUsername(userDTO.getUsername());
        }
        if (userDTO.getPassword() != null){
            user.setPassword(userDTO.getPassword());
        }
        return user;
    }
}
