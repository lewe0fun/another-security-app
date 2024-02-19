package ru.pakulin.Spring.Security.Login.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pakulin.Spring.Security.Login.models.AuthUser;
import ru.pakulin.Spring.Security.Login.models.User;
import ru.pakulin.Spring.Security.Login.services.AuthService;

@RestController
@RequestMapping("/api/access/")
public class AuthApi {
    private final AuthService authService;

    @Autowired
    public AuthApi(AuthService authService) {
        this.authService = authService;
    }
    @PostMapping("/register")
    public ResponseEntity<AuthUser> register(@RequestBody User auth){
        return  ResponseEntity.ok(authService.register(auth));
    }
    @PostMapping("/login")
    public ResponseEntity<AuthUser> login(@RequestBody User auth){
        return  ResponseEntity.ok(authService.authentication(auth));
    }
}
