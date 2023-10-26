package com.akechsalim.demo.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class BasicAuthenticationSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
                .authorizeHttpRequests(
                        auth ->
                                auth
                                        .anyRequest().authenticated())

                .httpBasic(Customizer.withDefaults())

                .sessionManagement(
                        session -> session.sessionCreationPolicy
                                (SessionCreationPolicy.STATELESS))
                .csrf().disable()
                .build();
    }
}