package com.example.buoi10.utils;

import com.example.buoi10.daos.User;
import com.example.buoi10.dtos.UserDTO;

public class Convert {
    public static User fromUserDTOToUser(UserDTO userDTO,User user){
        if (userDTO.getName() != null) {
            user.setName(userDTO.getName());
        }
        if (userDTO.getEmail() != null) {
            user.setEmail(userDTO.getEmail());
        }
        if (userDTO.getFavorite() != null) {
            user.setFavorite(userDTO.getFavorite());
        }
        return user;
    }
}
