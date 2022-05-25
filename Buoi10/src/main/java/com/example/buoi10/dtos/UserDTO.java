package com.example.buoi10.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    @NotBlank(message = "ten khong duoc de trong")
    private String name;

    @Email(message = "khong dung dinh dang")
    private String email;

    @Length(max = 100000,min = 10,message = "khong dam bao so luong ki tu")
    private String favorite;
}
