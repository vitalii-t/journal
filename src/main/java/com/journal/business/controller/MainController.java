package com.journal.business.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class MainController {
    @PreAuthorize("hasAnyAuthority('ADMIN','MONITOR','STUDENT','APPROVED','ANON')")
    @RequestMapping("/main")
    public String main() {
        return "main";
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }
}