package ru.pakulin.Spring.Security.Login.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pakulin.Spring.Security.Login.models.User;
import ru.pakulin.Spring.Security.Login.services.UserService;

@RestController
@RequestMapping("/api/people/")
public class UsersApi {
    private final UserService userService;

    @Autowired
    public UsersApi(UserService userService) {
        this.userService = userService;
    }
    @PostMapping()
    public User create(@RequestBody User user) {
        return userService.add(user);
    }
}
