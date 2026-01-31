package com.shi.studentmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringConfig {

    private static final String[] PUBLIC_Path ={
        "/login",
        "/css/**",
        "/images/**",
        "/js/**",
        "/error"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
    {
        http.authorizeHttpRequests(auth -> auth
            .requestMatchers(PUBLIC_Path).permitAll()
            .anyRequest().authenticated()
        
        )
            .formLogin(form -> form.loginPage("/login")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/dashboard", true)
                .permitAll())
        
            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout")
                .permitAll());

        return http.build();                      
    }

    // Password encoder bean
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
