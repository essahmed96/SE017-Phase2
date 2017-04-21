package com.hellokoding.account.web;





import com.hellokoding.account.model.Game;

import com.hellokoding.account.service.GameService6;
import com.hellokoding.account.service.SecurityService;







import com.hellokoding.account.validator.UserValidator6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GameController6 {
    @Autowired
    private GameService6 userService6;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator6 userValidator6;

    @RequestMapping(value = "/game", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new Game());

        return "game";
    }

    @RequestMapping(value = "/game", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") Game userForm, BindingResult bindingResult, Model model) {
        userValidator6.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "game";
        }

        userService6.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome6";
    }

    @RequestMapping(value = "/vgame", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "vgame";
    }

    @RequestMapping(value = {"/", "/welcome6"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome6";
    }
}
