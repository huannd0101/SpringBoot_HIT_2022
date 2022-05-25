package com.hit.buoi9.base;

import com.hit.buoi9.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class BaseController<T> {
    public ResponseEntity<?> resSuccess(T data) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseDTO<>(HttpStatus.OK.value(), "Success", data)
        );
    }

    public ResponseEntity<?> resListSuccess(List<T> list) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseDTO<>(HttpStatus.OK.value(), "Success", list)
        );
    }

    public ResponseEntity<?> resFailed() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ResponseDTO<>(HttpStatus.BAD_REQUEST.value(), "error", "Failed")
        );
    }
}
