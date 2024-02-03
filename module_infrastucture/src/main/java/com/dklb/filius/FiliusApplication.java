package com.dklb.filius;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

@SpringBootApplication(exclude = {UserDetailsServiceAutoConfiguration.class })
public class FiliusApplication {
    public static void main(String[] args) {
        SpringApplication.run(FiliusApplication.class, args);
    }
}
