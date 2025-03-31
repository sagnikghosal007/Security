package com.saggy.Security.config;


import com.saggy.Security.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserService userService;
    @Bean
    public SecurityFilterChain securityFilter(HttpSecurity http)throws Exception
    {
        //providing authorization of each and every request
        http.authorizeHttpRequests(request->request.requestMatchers("/","/aboutUs","contactUs").permitAll()
                .anyRequest().authenticated()).formLogin(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http)throws Exception{
       AuthenticationManagerBuilder builder=http.getSharedObject(AuthenticationManagerBuilder.class);
       builder.userDetailsService(userService).passwordEncoder(passwordEncoder());
       return builder.build();
    }
}
