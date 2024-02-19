/*
package ru.pakulin.Spring.Security.Login.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.pakulin.Spring.Security.Login.models.CustomUserDetails;
import io.jsonwebtoken.Jwts;
@Service
public class JwtService {
    @Value("${jwt.token.validity}")
    private long JWT_TOKEN_VALIDITY;

    @Value("${jwt.secret}")
    private String SECRET;
    public String generateToken(CustomUserDetails user){
        String token = Jwts
                .builder()
                .setSubject()

    }
}
*/
