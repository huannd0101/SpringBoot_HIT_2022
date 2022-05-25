package com.hit.buoi9.controller;

import com.hit.buoi9.base.BaseController;
import com.hit.buoi9.dto.UserDTO;
import com.hit.buoi9.models.User;
import com.hit.buoi9.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController extends BaseController<User> {

    @Autowired
    private UserServiceImp userService;

    /*
    * Tạo input
    * Chuyển qua service(useCaseBus, service)
    * Trả về output
    * */
    //    UserDataInput input = .....
//
//        UserDataOutput output = service.getData(input); //usecasebus
//
//        return output;

    @GetMapping("/users")
    public ResponseEntity<?> getAllUser() {
        return this.resListSuccess(userService.getAllUser());
    }

    @PostMapping("/users")
    public ResponseEntity<?> createNewUser(@ModelAttribute UserDTO userDTO) {
        return this.resSuccess(userService.createNewUser(userDTO));
    }

    @GetMapping("/param")
//    public ResponseEntity<?> getParam(@RequestParam("username") String username,
//                                      @RequestParam("password") String password,
//                                      @RequestParam("fullName") String fullName) {
    public ResponseEntity<?> getParam(@Validated UserDTO userDTO) {
        System.out.println(userDTO.getFullName());
        System.out.println(userDTO.getUsername());
        System.out.println(userDTO.getPassword());

        return this.resFailed();
    }

    @GetMapping("/data")
    public String getData() {
        return "https://github.com/huannd0101/TumiServer/blob/master/src/main/java/com/example/tumiweb/base/BaseController.java";
    }

}
