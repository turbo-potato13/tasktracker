package com.vtb.geekbrains.team.tasktracker.service;

import com.vtb.geekbrains.team.tasktracker.entity.Role;
import com.vtb.geekbrains.team.tasktracker.entity.User;
import com.vtb.geekbrains.team.tasktracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }


    public void registerUser(User user) {
        repository.findByName(user.getName()).ifPresentOrElse((u) ->
                {
                    throw new RuntimeException("User with this email " + u.getEmail() + " already exist");
                },
                () -> {
                    user.setPassword(passwordEncoder.encode(user.getPassword()));
                    Role role = roleService.findById(1L).orElseThrow(()->new RuntimeException());
                    user.setRoles(Collections.singletonList(role));
                    repository.save(user);
                });
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = findByEmail(s).orElseThrow(() -> new UsernameNotFoundException(String.format("User '%s' not found", s)));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));

    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
