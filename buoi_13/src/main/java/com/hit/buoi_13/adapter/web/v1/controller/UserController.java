package com.hit.buoi_13.adapter.web.v1.controller;

import com.hit.buoi_13.adapter.web.base.RestApiV1;
import com.hit.buoi_13.adapter.web.base.VsResponseUtil;
import com.hit.buoi_13.adapter.web.v1.transfer.parameter.user.GetListUserParameter;
import com.hit.buoi_13.application.constant.UrlConstant;
import com.hit.buoi_13.application.input.user.GetListUserInput;
import com.hit.buoi_13.application.output.user.GetListUserOutput;
import com.hit.buoi_13.application.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.Valid;

@RestApiV1
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping(UrlConstant.User.GET_LIST_USER)
  public ResponseEntity<?> getListUser(@Valid GetListUserParameter parameter) {
    //B1: khởi tạo input
    GetListUserInput input = new GetListUserInput(parameter.getAge());

    //B2: Lấy kết quả từ service
    GetListUserOutput output = userService.getListUser(input);

    //B3: return kết quả
    return VsResponseUtil.ok(output);
  }

}
