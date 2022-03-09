package com.hit.btvn_b4.controllers;

import com.hit.btvn_b4.models.User;
import com.hit.btvn_b4.repository.UserRepository;
import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("err", "");

        return "login";
    }

    @PostMapping("/login")
    public String loginProcess(
            @ModelAttribute("user") User user,
            Model model) {
        List<User> users = userRepository.findAll();
        if(users.contains(user)) {
            return "redirect:/";
        }

        model.addAttribute("err", "Tên đăng nhập hoặc mật khẩu không hợp lệ !");
        return "login";
    }

    @GetMapping("")
    public String getIndexPage(Model model) {
        model.addAttribute("users", userRepository.findAll());

        return "index";
    }
}