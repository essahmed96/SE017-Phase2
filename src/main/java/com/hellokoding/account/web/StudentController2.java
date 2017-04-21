package com.hellokoding.account.web;


import com.hellokoding.account.model.Student;
import com.hellokoding.account.service.SecurityService;

import com.hellokoding.account.service.StudentService2;

import com.hellokoding.account.validator.UserValidator2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController2 {
    @Autowired
    private StudentService2 userService2;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator2 userValidator2;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new Student());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") Student userForm, BindingResult bindingResult, Model model) {
        userValidator2.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration2";
        }

        userService2.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }
}
