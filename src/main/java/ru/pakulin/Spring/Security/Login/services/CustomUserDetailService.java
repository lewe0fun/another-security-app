package ru.pakulin.Spring.Security.Login.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ru.pakulin.Spring.Security.Login.models.CustomUserDetails;
import ru.pakulin.Spring.Security.Login.models.User;


public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private  UserService userService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userService.findByName(name)
                .orElseThrow(()->new UsernameNotFoundException("User with name "+name+" not found"));
        return  new CustomUserDetails(user);
    }
}
