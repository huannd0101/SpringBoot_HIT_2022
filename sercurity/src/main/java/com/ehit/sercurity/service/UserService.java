package com.ehit.sercurity.service;

import com.ehit.sercurity.dto.UserDto;
import com.ehit.sercurity.model.User;
import com.ehit.sercurity.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> getAllUser() {
    return userRepository.findAll();
  }

  public User createNewUser(UserDto userDto) {
    User user = new User(userDto.getUsername(), userDto.getPassword());

    return userRepository.save(user);
  }

  public User deleteUserById(Long id) {
    userRepository.deleteById(id);

    return userRepository.findById(id).get();
  }

}
