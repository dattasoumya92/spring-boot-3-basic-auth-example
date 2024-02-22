package com.poc.basicauth.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class BasicAuthConfigurer {

    @Value("${spring.security.basic.auth.user}")
    private String username;

    @Value("${spring.security.basic.auth.password}")
    private String password;

    @Bean
    public UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(User
                .withUsername(username)
                .password("{bcrypt}" + password)
                .roles("USER")
                .build());
    }

    // Configuring HttpSecurity
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests((requests) -> requests
                        // permits all actuator health check URLs
                        .requestMatchers("/actuator/**").permitAll()
                        // any other request should be authenticated
                        .anyRequest().authenticated()
                )
                // disabling CSRF
                .csrf(AbstractHttpConfigurer::disable)
                // basic auth with default settings
                .httpBasic(withDefaults())
                .build();
    }

}
