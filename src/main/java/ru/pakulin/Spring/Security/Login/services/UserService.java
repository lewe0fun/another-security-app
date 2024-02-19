package ru.pakulin.Spring.Security.Login.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.pakulin.Spring.Security.Login.models.User;
import ru.pakulin.Spring.Security.Login.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
@Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
}
    public Optional<User> findByName(String name){
    return userRepository.findByUsername(name);
    }

    public List<User> findAll() {
    return userRepository.findAll();
    }

    public void add(User user) {
     user.setPassword(passwordEncoder.encode(user.getPassword()));
    userRepository.save(user);
    }
}
