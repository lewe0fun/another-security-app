package ru.pakulin.Spring.Security.Login.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.pakulin.Spring.Security.Login.domain.factory.UserCardFactoryEssential;
import ru.pakulin.Spring.Security.Login.domain.factory.UserCardFactoryOrdinary;

@Configuration
public class SpringConfig {
    @Bean("Ordinary")
    public UserCardFactoryOrdinary userCardFactoryOrdinary(){
        return new UserCardFactoryOrdinary();
    }
    @Bean("Essential")
    public UserCardFactoryEssential userCardFactoryEssential(){
        return new UserCardFactoryEssential();
    }
}
