package ru.pakulin.Spring.Security.Login.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.pakulin.Spring.Security.Login.repositories.SessionRepository;
import ru.pakulin.Spring.Security.Login.repositories.UserRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class AuthServiceTest {
    @InjectMocks
    private UserRepository userRepository;
    @Mock
    private SessionRepository sessionRepository;


    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void register() {
    }

    @Test
    void authentication() {
    }
}