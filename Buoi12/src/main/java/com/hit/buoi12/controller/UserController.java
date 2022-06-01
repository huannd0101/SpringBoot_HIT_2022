package com.hit.buoi12.controller;

import com.hit.buoi12.utils.DateUtil;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @GetMapping()
  public ResponseEntity<?> viewData(@RequestBody DateUtil dateTimeUtil, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return ResponseEntity.ok(bindingResult.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage));
    }
    return ResponseEntity.ok(dateTimeUtil);
  }

}
