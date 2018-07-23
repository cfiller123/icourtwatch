package com.carlfiller.icourtwatch.controllers;

import com.carlfiller.icourtwatch.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("title", "User Management Page");
        return "user/index";
    }

    @RequestMapping(value = "signup", method = RequestMethod.GET)
    public String displayUserSignUpForm(Model model) {
        model.addAttribute(new User());
        model.addAttribute("title", "Register Your Account");
        return "user/signup";
    }
}
