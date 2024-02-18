package ru.pakulin.Spring.Security.Login.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("")
    public String viewHomePage(Model model) {

        return "index";
    }

    @GetMapping("/admin/login")
    public String adminLogin() {
        return "admin/admin_login";
    }

    @GetMapping("/user/login")
    public String userLogin() {
        return "user/user_login";
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
