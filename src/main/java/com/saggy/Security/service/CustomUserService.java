package com.saggy.Security.service;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      if(!username.equals("sagnik")){
          throw new UsernameNotFoundException("User not found ");
      }
      String encodedPass=new BCryptPasswordEncoder().encode("root");
      return User
              .withUsername("sagnik")
              .password(encodedPass)
              .roles("USER")
              .build();
    }
}
