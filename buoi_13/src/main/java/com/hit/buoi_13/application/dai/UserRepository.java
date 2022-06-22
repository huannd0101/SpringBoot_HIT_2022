package com.hit.buoi_13.application.dai;

import com.hit.buoi_13.domain.dto.UserDto;

import java.util.List;

public interface UserRepository {

  List<UserDto> findAllUser(UserDto userDto);

}
