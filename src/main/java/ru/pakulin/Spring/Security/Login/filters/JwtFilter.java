package ru.pakulin.Spring.Security.Login.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.pakulin.Spring.Security.Login.services.JwtService;
import ru.pakulin.Spring.Security.Login.services.UserDetailServiceImp;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserDetailServiceImp userDetailServiceImp;

    @Autowired
    public JwtFilter(JwtService jwtService, UserDetailServiceImp userDetails) {
        this.jwtService = jwtService;
        this.userDetailServiceImp = userDetails;
    }

    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request,
                                    @NotNull HttpServletResponse response,
                                    @NotNull FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        String jwt = authHeader.substring(7);
        String username = jwtService.extractUsername(jwt);
        if (username != null && SecurityContextHolder
                .getContext()
                .getAuthentication() == null) {
            UserDetails userDetails = userDetailServiceImp.loadUserByUsername(username);
            if (jwtService.isValid(jwt, userDetails)) {
                UsernamePasswordAuthenticationToken authJwt = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities()
                );
                authJwt.setDetails(
                        new WebAuthenticationDetailsSource()
                                .buildDetails(request)
                );

            }
        }
        filterChain.doFilter(request, response);
    }

}
