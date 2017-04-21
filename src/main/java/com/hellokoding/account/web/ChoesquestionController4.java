package com.hellokoding.account.web;




import com.hellokoding.account.model.Choesquestion;
import com.hellokoding.account.service.SecurityService;



import com.hellokoding.account.service.ChoesquestionService4;

import com.hellokoding.account.validator.UserValidator4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ChoesquestionController4 {
    @Autowired
    private ChoesquestionService4 userService4;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator4 userValidator4;

    @RequestMapping(value = "/que", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new Choesquestion());

        return "que";
    }

    @RequestMapping(value = "/que", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") Choesquestion userForm, BindingResult bindingResult, Model model) {
        userValidator4.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "que";
        }

        userService4.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome4";
    }

    @RequestMapping(value = "/ans", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "ans";
    }

    @RequestMapping(value = {"/", "/welcome4"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome4";
    }
}
