package com.techelevator.security;

import com.techelevator.security.jwt.TokenProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfig {
    public SecurityConfig(TokenProvider tokenProvider, JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint, JwtAccessDeniedHandler jwtAccessDeniedHandler, UserModelDetailsService userModelDetailsService) {
        super(tokenProvider, jwtAuthenticationEntryPoint, jwtAccessDeniedHandler, userModelDetailsService);
    }

    // ...other configurations...

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // ...other configurations...
                .logout()
                .logoutUrl("/logout") // Configure the logout URL
                .invalidateHttpSession(true) // Invalidate the HTTP session
                .deleteCookies("JSESSIONID") // Delete cookies
                .clearAuthentication(true) // Clear authentication
                .logoutSuccessUrl("/") // Set the URL to redirect to after logout
                .and();
        // ...other configurations...
    }
}
