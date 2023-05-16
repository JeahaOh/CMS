package com.portfolio.cms.webTest.config;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable().cors().disable()
                .authorizeHttpRequests(request -> request
                        .dispatcherTypeMatchers(DispatcherType.FORWARD)
                        .permitAll()
                        .requestMatchers(
                                "/status",
                                "/images/**",
                                "/js/**",
                                "/css/**",
                                "/bootstrap/**",
                                "/join",
                                "/auth/join"
                        )
                        .permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        .loginPage("/login")
                        .loginProcessingUrl("/login-process")
                        .usernameParameter("memberId")
                        .passwordParameter("pwd")
                        .defaultSuccessUrl("/", true)
                        .permitAll()
                )
                .logout(Customizer.withDefaults());
        return httpSecurity.build();
    }
    
    @Bean
    PasswordEncoder passwordEncoder() {
        return new Sha512PasswordEncoder();
    }
}
