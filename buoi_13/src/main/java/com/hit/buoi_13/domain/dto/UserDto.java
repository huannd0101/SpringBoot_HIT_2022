package com.hit.buoi_13.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

  private Long id;

  private Integer age;

  private String email;

  private String password;

  private String firstName;

  private String lastName;

}
