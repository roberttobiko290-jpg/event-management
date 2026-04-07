package com.eventmanagement.eventmanagementsystem.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfig {

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

            http
                    .csrf(csrf -> csrf.disable())
                    .authorizeHttpRequests(auth -> auth

                            // Public endpoints
                            .requestMatchers("/api/auth/**").permitAll()

                            // Protected endpoints
                            .requestMatchers("/api/booking/**").authenticated()
                            .requestMatchers("/api/event/**").authenticated()
                            .requestMatchers("/api/notification/**").authenticated()
                            .requestMatchers("/api/payment/**").authenticated()
                            .requestMatchers("/api/user/**").authenticated()
                            // Everything else
                            .anyRequest().permitAll()
                    );

            return http.build();
        }
    }
