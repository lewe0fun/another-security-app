package ru.pakulin.Spring.Security.Login.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {
    @GetMapping("/")
    public String index(){
    return"home";
    }
    @GetMapping("/login")
    public String login(){
        return"login";
    }

    @GetMapping("/admin/home")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public String adminHome() {
        return "admin/admin_home";
    }

    @GetMapping("/user/home")
   // @PreAuthorize("hasAuthority('USER')")
    public String userHome() {
        return "user/user_home";
    }
}
