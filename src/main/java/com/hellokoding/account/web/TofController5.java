package com.hellokoding.account.web;





import com.hellokoding.account.model.Tof;
import com.hellokoding.account.service.SecurityService;




import com.hellokoding.account.service.TofService5;

import com.hellokoding.account.validator.UserValidator5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TofController5 {
    @Autowired
    private TofService5 userService5;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator5 userValidator5;

    @RequestMapping(value = "/tof", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new Tof());

        return "tof";
    }

    @RequestMapping(value = "/tof", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") Tof userForm, BindingResult bindingResult, Model model) {
        userValidator5.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "tof";
        }

        userService5.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome5";
    }

    @RequestMapping(value = "/vtof", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "vtof";
    }

    @RequestMapping(value = {"/", "/welcome5"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome5";
    }
}
