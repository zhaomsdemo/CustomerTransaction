package com.zhaomsdemo.customertransaction.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
//@EnableMethodSecurity(securedEnabled = true)
//@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    public SecurityFilterChain config(HttpSecurity http) throws Exception {
//        return http.authorizeHttpRequests(requests ->
//            requests.anyRequest().permitAll()
//        ).build();
//    }
}
