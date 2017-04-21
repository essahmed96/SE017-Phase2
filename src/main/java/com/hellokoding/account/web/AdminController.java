package com.hellokoding.account.web;

import com.hellokoding.account.model.Admin;
import com.hellokoding.account.service.SecurityService;
import com.hellokoding.account.service.AdminService;
import com.hellokoding.account.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
    @Autowired
    private AdminService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration2", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new Admin());

        return "registration2";
    }

    @RequestMapping(value = "/registration2", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") Admin userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration2";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome2";
    }

    @RequestMapping(value = "/login2", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login2";
    }

    @RequestMapping(value = {"/", "/welcome2"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome2";
    }
}
