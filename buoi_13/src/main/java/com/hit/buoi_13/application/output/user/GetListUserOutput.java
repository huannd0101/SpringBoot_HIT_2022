package com.hit.buoi_13.application.output.user;

import com.hit.buoi_13.domain.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetListUserOutput {

  private List<UserDto> items;

}
