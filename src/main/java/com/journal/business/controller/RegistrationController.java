package com.journal.business.controller;

import com.journal.data.entities.Group;
import com.journal.data.entities.Role;
import com.journal.data.entities.User;
import com.journal.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@Controller
public class RegistrationController {

    private UserRepository userRepository;

    @Autowired
    public RegistrationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping(path = "/registration")
    public String addUser(User user, Model model) {
        User dbUser = userRepository.findByUsername(user.getUsername());
        if(null!=dbUser){
            model.addAttribute("msg","USER ALREADY EXISTS");
            return "registration";
        }
        Group group = new Group();
        group.setIdentifier("CI-161");
        group.setUsers(Collections.singletonList(user));
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.ADMIN));
        user.setGroup(group);
        userRepository.save(user);
        return "redirect:/login";
    }
//
//    @RequestMapping("/login")
//    public String login() {
//        return "login";
//    }
}