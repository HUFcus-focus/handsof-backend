package com.handsof.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login_form")
    public String loginForm() {
        return "login";
    }

    @GetMapping("/login")
    public String login() {
        return "message_list";
    }
}
