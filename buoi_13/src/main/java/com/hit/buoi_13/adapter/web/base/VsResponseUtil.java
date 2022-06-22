package com.hit.buoi_13.adapter.web.base;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class VsResponseUtil {

  public static ResponseEntity<RestData<?>> ok(Object data) {
    return ok(HttpStatus.OK, data);
  }

  public static ResponseEntity<RestData<?>> ok(HttpStatus status, Object data) {
    RestData<?> response = new RestData<>(data);
    return new ResponseEntity<>(response, status);
  }

  public static ResponseEntity<RestData<?>> error(HttpStatus status, String userMessage, String devMessage) {
    RestData<?> response = RestData.error(userMessage, devMessage);
    return new ResponseEntity<>(response, status);
  }

  public static ResponseEntity<RestData<?>> error(HttpStatus status, String userMessage) {
    RestData<?> response = RestData.error(userMessage);
    return new ResponseEntity<>(response, status);
  }

}
