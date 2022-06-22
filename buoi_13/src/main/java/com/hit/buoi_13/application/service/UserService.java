package com.hit.buoi_13.application.service;

import com.hit.buoi_13.application.dai.UserRepository;
import com.hit.buoi_13.application.input.user.GetListUserInput;
import com.hit.buoi_13.application.output.user.GetListUserOutput;
import com.hit.buoi_13.domain.dto.UserDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ApplicationUserService")
public class UserService {
  private final UserRepository userRepository;

  public UserService(@Qualifier("DatabaseUserRepository") UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public GetListUserOutput getListUser(GetListUserInput input) {
    UserDto userDto = new UserDto();
    userDto.setAge(input.getAge());
//
    return new GetListUserOutput(userRepository.findAllUser(userDto));
  }

}
