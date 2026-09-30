package com.dohieuhien.ojt.hieuhien_developingcrud_lab1.config;

import com.dohieuhien.ojt.hieuhien_developingcrud_lab1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

    @Configuration
    @EnableWebSecurity
    @EnableMethodSecurity
    @RequiredArgsConstructor
    public class SecurityConfig {

        private final JwtAuthFilter jwtAuthFilter;
        private final UserService userService;

        @Bean
        public PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
        }

        @Bean
        public AuthenticationManager authenticationManager(){
            DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userService)    ;
            provider.setPasswordEncoder(passwordEncoder());
            return new ProviderManager(provider);
        }
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http, JwtUtils jwtUtils) throws Exception{
        http.csrf(csrf -> csrf.disable())
                .cors(Customizer.withDefaults())
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .formLogin(form -> form.disable())
                .httpBasic(basic -> basic.disable())
                .authorizeHttpRequests(auth ->auth
                        .requestMatchers("/hien/auth/**").permitAll()
                        .requestMatchers("/hien/"));
       return http.build();
    }
}
