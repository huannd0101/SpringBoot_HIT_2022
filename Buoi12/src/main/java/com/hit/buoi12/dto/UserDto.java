package com.hit.buoi12.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

  //  @NotNull
//  @NotEmpty
  @NotBlank(message = "Username không được null or empty")
//  @Pattern(regexp = "^.{8,}$", message = "Username bắt buộc phải lớn 8 kí tự")
  @Size(min = 8, message = "Username bắt buộc phải lớn 8 kí tự")
  private String username;

  @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
      message = "Password không được mạnh")
  private String password;

  @Min(value = 18, message = "Age phải lớn hơn hoặc bằng 18 tuổi\nabc")
  @Max(value = 100, message = "Age phải nhỏ hơn hoặc bằng 100 tuổi")
  private Integer age;

}
