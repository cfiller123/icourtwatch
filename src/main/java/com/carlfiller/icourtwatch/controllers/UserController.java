package com.carlfiller.icourtwatch.controllers;

import com.carlfiller.icourtwatch.models.User;
import com.carlfiller.icourtwatch.models.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request) {
//        request.getCookies();
//        TODO: check if a "user" cookie exists; if not, send to login page. If exists, welcome user by name.
        model.addAttribute("title", "User Management Page");
        return "user/index";
    }

    @RequestMapping(value = "signup", method = RequestMethod.GET)
    public String displayUserSignUpForm(Model model) {
        model.addAttribute(new User());
        model.addAttribute("title", "Register Your Account");
        return "user/signup";
    }

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public String processUserSignUpForm(Model model, @ModelAttribute @Valid User user, Errors errors, HttpServletResponse response) {
        model.addAttribute(user);
//TODO Make sure account doesn't already exist.
        if (!errors.hasErrors()) {
            userDao.save(user);
//            Cookie logincookie = new Cookie("user", user.getUsername());
//            response.addCookie(logincookie);
            return "judge/index";
        }

        model.addAttribute("title", "Register Your Account");
        return "user/signup";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String displayUserLoginForm(Model model) {
        model.addAttribute("title", "Login");
        return "user/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String processUserLoginForm(Model model, @ModelAttribute @Valid User user, Errors errors, HttpServletResponse response) {
        return "redirect:";
    }
}
