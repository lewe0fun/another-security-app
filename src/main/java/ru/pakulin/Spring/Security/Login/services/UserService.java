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

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User add(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return user;
    }

    public List<User> findByAge(int age) {
        return userRepository.findByAge(age);
    }

    public List<User> findByAgeMoreThen(int age) {
        return userRepository.findByAgeMoreThen(age);
    }

    public List<User> findByAgeLessThen(int age) {
        return userRepository.findByAgeLessThen(age);
    }

    public List<User> findByName(String name) {
       return userRepository.findByName(name);
    }

    public User save(User user) {
        return userRepository.save( user);
    }

    public User update(long id, User user) {
        user.setId(id);
       return userRepository.save(user);
    }

    public void delete(long id) {
        userRepository.deleteById(id);
    }
}
