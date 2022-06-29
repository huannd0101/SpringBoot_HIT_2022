package com.hit.buoi_13.infrastructure.repository.database;

import com.hit.buoi_13.application.dai.UserRepository;
import com.hit.buoi_13.domain.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("DatabaseUserRepository")
@Mapper
public interface DatabaseUserRepository extends UserRepository {

  @Override
  List<UserDto> findAllUser(@Param("item") UserDto userDto);

}