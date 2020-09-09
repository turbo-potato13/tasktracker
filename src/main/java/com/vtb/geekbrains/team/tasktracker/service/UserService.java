package com.vtb.geekbrains.team.tasktracker.service;

import com.vtb.geekbrains.team.tasktracker.entity.User;
import com.vtb.geekbrains.team.tasktracker.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;


    public User findByEmail(String email) {
        return repository.findByName()
    }


    public void registerUser(User user) {
        repository.findByName(user.getName()).ifPresentOrElse((u) ->
                {
                    throw new RuntimeException("User with this email " + u.getEmail() + " already exist");
                },
                () -> {
                    user.setPassword(passwordEncoder.encode(user.getPassword()));
                    user.setRole(User.Role.USER);
                    repository.save(user);
                });
    }
}
