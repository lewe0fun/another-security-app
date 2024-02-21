package ru.pakulin.Spring.Security.Login.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.pakulin.Spring.Security.Login.models.AuthUser;
import ru.pakulin.Spring.Security.Login.models.Role;
import ru.pakulin.Spring.Security.Login.models.User;
import ru.pakulin.Spring.Security.Login.repositories.UserRepository;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration
class AuthServiceTest {
    @InjectMocks
    private AuthService authService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private JwtService jwtService;
    @Mock
    private AuthenticationManager authenticationManager;
    User user;

    @BeforeEach
    public void setup() {
        user = new User("testUser", "user@mail.com", "testUser", Role.USER);
        MockitoAnnotations.openMocks(this);

    }

    /**
     * при успешной регистрации метод `save` репозитория пользователя вызывается.
     **/
    @Test
    void register() {

        authService.register(user);
        Mockito.verify(userRepository, Mockito.atMost(1)).save(user);

    }

    /**
     * при входе в систему для существующего пользователя создается новая сессия. (какая сессия с jwt?)
     */
    @Test
    void authentication() {
        when(userRepository.findByUsername(user.getUsername())).thenReturn(Optional.ofNullable(user));

        Authentication authentication =new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        authenticationManager.authenticate(authentication);
        System.out.println(authentication.isAuthenticated());
        User user2 = userRepository.findByUsername(user.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User with name " + user.getUsername() + " not found"));
        AuthUser auth = new AuthUser(jwtService.generateToken(user2));
        System.out.println(auth.getJwt());
        assertThat(authentication.isAuthenticated()).isFalse();
    }
}