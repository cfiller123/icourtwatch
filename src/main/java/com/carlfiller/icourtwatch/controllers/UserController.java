package com.carlfiller.icourtwatch.controllers;

import com.carlfiller.icourtwatch.models.User;
import com.carlfiller.icourtwatch.models.forms.LoginForm;
import com.carlfiller.icourtwatch.models.forms.RegisterForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController extends AbstractController {

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("title", "Welcome to CourtWatch!");
        return "user/index";
    }

    @RequestMapping(value = "signup", method = RequestMethod.GET)
    public String signupForm (Model model) {
        model.addAttribute(new RegisterForm());
        model.addAttribute("title", "Register Your Account");
        return "user/signup";
    }

    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public String processSignupForm (@ModelAttribute @Valid RegisterForm form, Errors errors, Model model, HttpServletRequest request) {

        if (errors.hasErrors()) {
            return "user/signup";
        }

        User existingUser = userDao.findByUsername(form.getUsername());

        if (existingUser != null) {
            errors.rejectValue("username", "username.alreadyexists","A user with that username already exists");
            model.addAttribute("title", "Register Your Account");
            return "user/signup";
        }

        User newUser = new User(form.getUsername(), form.getPassword());
        userDao.save(newUser);
        setUserInSession(request.getSession(), newUser);
        return "redirect:/judge/index";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login (Model model) {
        model.addAttribute(new LoginForm());
        model.addAttribute("title", "Log In");
        return "user/login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login (@ModelAttribute @Valid LoginForm form, Errors errors, HttpServletRequest request) {

        if (errors.hasErrors()) {
            return "user/login";
        }

        User theUser = userDao.findByUsername(form.getUsername());
        String password = form.getPassword();

        if (theUser == null) {
            errors.rejectValue("username", "user.invalid", "The given username does not exist");
            return "login";
        }

        if (!theUser.isMatchingPassword(password)) {
            errors.rejectValue("password", "password.invalid", "Invalid password");
            return "login";
        }

        setUserInSession(request.getSession(), theUser);
        return "redirect:/judge/index";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/login";
    }
}
