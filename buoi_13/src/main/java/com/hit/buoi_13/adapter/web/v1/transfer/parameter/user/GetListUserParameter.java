package com.hit.buoi_13.adapter.web.v1.transfer.parameter.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GetListUserParameter {

  @Min(value = 1, message = "invalid.age.min")
  private Integer age;

}
