package com.journal.business.controller;

import com.journal.business.service.UserService;
import com.journal.data.entities.Role;
import com.journal.data.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    @PreAuthorize("hasAnyAuthority('ADMIN','MONITOR')")
    public String getAllUsers(Model model){

        List<User> users = userService.findAllUsers();


        model.addAttribute("user",users);

        return "users";
    }

}