package com.vtb.geekbrains.team.tasktracker.service;

import com.vtb.geekbrains.team.tasktracker.entity.Role;
import com.vtb.geekbrains.team.tasktracker.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RoleService {

    public final RoleRepository roleRepository;

    public Optional<Role> findById(Long id){
        return roleRepository.findById(id);
    }
    public Optional<Role> findByName(String name){
        return roleRepository.findByName(name);
    }
}
