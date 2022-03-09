package com.example.btvn_b3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
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

        if(Store.getUsers().contains(user)) {
            return "redirect:/";
        }

        model.addAttribute("err", "Tên đăng nhập hoặc mật khẩu không hợp lệ !");
        return "login";
    }

    @GetMapping("")
    public String getIndexPage(Model model) {
        model.addAttribute("users", Store.getUsers());

        return "index";
    }
}
