package com.fiap.hackaton.cyberpay.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
   @Bean
   DefaultSecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      return http
              .authorizeHttpRequests(
                      authorizeConfig -> {
                         authorizeConfig.requestMatchers("/cliente/buscarTodos").permitAll();
                         authorizeConfig.requestMatchers("/logout").permitAll();
                         authorizeConfig.anyRequest().authenticated();
                      }).httpBasic(Customizer.withDefaults())
              .build();
   }
}
