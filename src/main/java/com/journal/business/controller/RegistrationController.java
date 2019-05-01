package com.journal.business.controller;

import com.journal.business.service.UserService;
import com.journal.data.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class RegistrationController {

    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping(path = "/registration")
    public String addUser(User user, Map<String, Object> model) {
        if (!userService.addUser(user)) {
            model.put("msg", "User exists!");
            return "registration";
        }
        return "redirect:/login";
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code) {
        boolean isActivated = userService.activateUser(code);

        if (isActivated) {
            model.addAttribute("message", "Account successfully activated");

        } else {
            model.addAttribute("message", "Activation code is not found!");
        }

        return "activate";
    }
}