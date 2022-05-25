package com.hit.buoi9.service.imp;

import com.hit.buoi9.dto.UserDTO;
import com.hit.buoi9.models.User;
import com.hit.buoi9.repository.UserRepository;
import com.hit.buoi9.service.UserService;
import com.hit.buoi9.utils.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UploadFile uploadFile;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getAllUserByName(String name) {
        return null;
    }

    @Override
    public User createNewUser(UserDTO userDTO) {
        User user = new User(
                userDTO.getUsername(),
                userDTO.getPassword(),
                userDTO.getFullName(),
                null
        );
//        user.setAvatar(uploadFile.getUrlFromFile(userDTO.getAvatar()));
        System.out.println(1);
        return userRepository.save(user);
    }


}
