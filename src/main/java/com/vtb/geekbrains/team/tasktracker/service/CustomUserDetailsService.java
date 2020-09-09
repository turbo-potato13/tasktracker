package com.vtb.geekbrains.team.tasktracker.service;

import com.vtb.geekbrains.team.tasktracker.config.jwt.CustomUserDetails;
import com.vtb.geekbrains.team.tasktracker.entity.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;
import java.util.Collection;

@Data
public class CustomUserDetailsService implements UserDetails {

    private UserService userService;

    @Override
    public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = userService.(username);
        return CustomUserDetails.fromUserEntityToCustomUserDetails(userEntity);
    }
}
