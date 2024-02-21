package ru.pakulin.Spring.Security.Login.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.pakulin.Spring.Security.Login.models.AuthUser;
import ru.pakulin.Spring.Security.Login.models.User;
import ru.pakulin.Spring.Security.Login.repositories.UserRepository;



@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthUser register(User auth) {
        User user = new User();
        user.setUsername(auth.getUsername());
        user.setEmail(auth.getEmail());
        user.setPassword(passwordEncoder.encode(auth.getPassword()));
        user.setRole(auth.getRole());
        user = userRepository.save(user);
        return new AuthUser(jwtService.generateToken(user));
    }

    public AuthUser authentication(User auth) {
        String name = auth.getUsername();
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        name,
                        auth.getPassword()
                )
        );
        User user = userRepository.findByUsername(name).orElseThrow(() -> new UsernameNotFoundException("User with name " + name + " not found"));
        return new AuthUser(jwtService.generateToken(user));
    }
}
