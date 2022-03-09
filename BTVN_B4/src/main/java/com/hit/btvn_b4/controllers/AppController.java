package com.hit.btvn_b4.controllers;

import com.hit.btvn_b4.models.User;
import com.hit.btvn_b4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {
    @Autowired
    private UserRepository userRepository;

    //edit
    @GetMapping("/edit")
    public String getEditPage(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", userRepository.getById(id));

        return "edit";
    }

    @PostMapping("edit")
    public String processEditUser(@ModelAttribute("user") User user) {
        User newUser = new User(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getFullName()
        );

        userRepository.save(newUser);

        return "redirect:/";
    }

    //create
    @GetMapping("/create")
    public String getCreatePage(Model model) {
        model.addAttribute("user", new User());

        return "create";
    }

    @PostMapping("/create")
    public String ProcessCreateUser(@ModelAttribute("user") User user) {
        userRepository.save(user);

        return "redirect:/";
    }

    //delete
    @GetMapping("/delete")
    public String getDeletePage(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", userRepository.getById(id));

        return "confirm";
    }

    @PostMapping("/delete")
    public String processDeleteUser(@ModelAttribute("user") User user) {
        userRepository.deleteById(user.getId());

        return "redirect:/";
    }

}
