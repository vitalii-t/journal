package com.journal.business.controller;

import com.journal.business.service.UserService;
import com.journal.data.dto.UserDto;
import com.journal.data.entities.Role;
import com.journal.data.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/users")
@PreAuthorize("hasAnyAuthority('ADMIN','MONITOR','STUDENT')")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllUsers(Model model) {

        List<UserDto> users = userService.findAllUsers().stream()
                .map(UserDto::new)
                .collect(Collectors.toList());
        model.addAttribute("user", users);

        return "users";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        List<Role> roles = Arrays.asList(Role.values());
        model.addAttribute("roles", roles);
        return "userEdit";
    }

    @PostMapping
    public String userEdit(
            @RequestParam String username,
            @RequestParam String email,
            @RequestParam String group,
            @RequestParam Map<String, String> form,
            @RequestParam("id") User user
    ) {
        userService.edit(user, username, email,group,form);
        return "redirect:/users";
    }
}