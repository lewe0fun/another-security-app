package ru.pakulin.Spring.Security.Login.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    @GetMapping("/home")
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
