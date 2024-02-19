package ru.pakulin.Spring.Security.Login.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.pakulin.Spring.Security.Login.models.User;
import ru.pakulin.Spring.Security.Login.services.UserService;


@Controller
@RequestMapping("/people")
public class PeopleController {
    private final UserService userService;

    @Autowired

    public PeopleController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") User user) {
        return "people/new";
    }

    @PostMapping("/people")
    public String create(@ModelAttribute("person")
                         @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "people/new";
        }
        userService.add(user);
        return "redirect:/";
    }
    @GetMapping("")
    public String index(Model model){
        model.addAttribute("users", userService.findAll());
        return "people/index";}
}

