package com.dklb.filius.infrastructure.config.security;


import com.dklb.filius.infrastructure.helpers.exception.AccessDeniedHandlerCustom;
import com.dklb.filius.infrastructure.helpers.exception.AuthenticationEntryPointCustom;
import com.google.firebase.FirebaseApp;
import domain.enums.RoleEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;


import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class HttpSecurityConfig {


    @Autowired
    private JwtAuthFilter jwtAuthFilter;

    @Autowired
    AuthenticationEntryPointCustom authenticationEntryPointCustom;

    @Autowired
    AccessDeniedHandlerCustom accessDeniedHandlerCustom;

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);
        http.formLogin(AbstractHttpConfigurer::disable);
        http.httpBasic(AbstractHttpConfigurer::disable);
        http.sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        http.authorizeHttpRequests(authReq ->
        {
            authReq.requestMatchers(HttpMethod.GET, "/filiusApi/admin/**")
                    .hasAuthority(RoleEnum.ROLE_ADMIN.name());
            authReq.requestMatchers(HttpMethod.POST, "/filiusApi/admin/**")
                    .hasAuthority(RoleEnum.ROLE_ADMIN.name());
            authReq.requestMatchers(HttpMethod.GET, "/filiusApi/user/**")
                    .hasAuthority(RoleEnum.ROLE_USER.name());
            authReq.requestMatchers(HttpMethod.POST, "/filiusApi/user/**")
                    .hasAuthority(RoleEnum.ROLE_USER.name());
            authReq.requestMatchers(HttpMethod.GET, "/filiusApi/free/**")
                    .permitAll();
            authReq.requestMatchers(HttpMethod.POST, "/filiusApi/free/**")
                    .permitAll();
            authReq.requestMatchers(HttpMethod.POST, "/encrypt")
                    .permitAll();
            authReq.requestMatchers("/v3/api-docs/**", "/swagger-ui/**").permitAll();


            authReq.anyRequest().authenticated();


        });
        http.exceptionHandling(handling -> {
            handling.authenticationEntryPoint(authenticationEntryPointCustom);
            handling.accessDeniedHandler(accessDeniedHandlerCustom);
        });

    return http.build();

    }
}
