package com.hit.buoi2;

import com.hit.buoi2.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
public class HomeController {

    @GetMapping("")
    public String getHone() {
        return "index";
    }

    @GetMapping("/about")
    public String getAbout() {
        return "about";
    }

    @GetMapping("/contact")
    public String getContact() {
        return "contact";
    }

    //Thymleaf
//    @GetMapping("/login")
//    public String getLoginPage(Model model) {
//        Account account = new Account("huannd0101", "123");
//        model.addAttribute("acc", account);
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String getRes(@ModelAttribute Account account) {
//        if(account.getUsername().equals("huan") && account.getPassword().equals("123")) {
//            return "index";
//        }
//        return "redirect:login";
//    }
//

    @GetMapping("/login")
    public ModelAndView getLoginPage() {
        ModelAndView mav = new ModelAndView("login");

        mav.addObject("acc", new Account());

        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("123", "345"));
        accounts.add(new Account("12sdf3", "aaaa"));
        accounts.add(new Account("123sdf", "aasdfsd"));

        mav.addObject("accs", accounts);

        return mav;
    }

    @PostMapping("/login")
    public String getResult(@ModelAttribute Account account) {
        System.out.println(account.getUsername());
        System.out.println(account.getPassword());

        return "index";
    }
}
