package com.vtb.geekbrains.team.tasktracker.service;

import com.vtb.geekbrains.team.tasktracker.config.jwt.CustomUserDetails;
import com.vtb.geekbrains.team.tasktracker.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Data
@Service
@AllArgsConstructor
public class CustomUserDetailsService {
//
//    private UserService userService;
//
//
//
//    @Override
//    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User userEntity = userService.findByEmail(username).orElseThrow(()->new UsernameNotFoundException("Use with this Email "+username+" not found"));
//        return CustomUserDetails.fromUserEntityToCustomUserDetails(userEntity);
//    }
}
