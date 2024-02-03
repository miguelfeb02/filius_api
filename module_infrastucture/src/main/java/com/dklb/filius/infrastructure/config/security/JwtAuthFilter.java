package com.dklb.filius.infrastructure.config.security;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;


import java.io.IOException;
import java.util.List;


@Slf4j
@Component
public class JwtAuthFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String idToken = request.getHeader("Authorization");
        if (!StringUtils.hasText(idToken)) {
            filterChain.doFilter(request, response);
            return;
        }
        FirebaseToken decodedToken = null;
        try {
            decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);

        } catch (FirebaseAuthException e) {
            log.info("Firebase Exception {}", e.getLocalizedMessage());
        }
        if (decodedToken != null) {
            String email = decodedToken.getEmail();
            String authoritie = decodedToken.getClaims().get("authorities").toString();
            List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(authoritie));
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                    email, decodedToken, authorities);
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);

        }
        filterChain.doFilter(request, response);

    }


}
