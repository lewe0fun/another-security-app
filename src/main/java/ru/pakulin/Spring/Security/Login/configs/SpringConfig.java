package ru.pakulin.Spring.Security.Login.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.pakulin.Spring.Security.Login.models.UserCardFactory;

@Configuration
public class SpringConfig {
    @Bean
    public UserCardFactory userCardFactory(){
        return new UserCardFactory();
    }
}
