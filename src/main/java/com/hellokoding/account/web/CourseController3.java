package com.hellokoding.account.web;



import com.hellokoding.account.model.Course;
import com.hellokoding.account.service.SecurityService;


import com.hellokoding.account.service.CourseService3;

import com.hellokoding.account.validator.UserValidator3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CourseController3 {
    @Autowired
    private CourseService3 userService3;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator3 userValidator3;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new Course());

        return "add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") Course userForm, BindingResult bindingResult, Model model) {
        userValidator3.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "add";
        }

        userService3.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome3";
    }

    @RequestMapping(value = "/chos", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "chos";
    }

    @RequestMapping(value = {"/", "/welcome3"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome3";
    }
}
