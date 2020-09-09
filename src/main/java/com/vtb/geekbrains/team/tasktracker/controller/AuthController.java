package com.vtb.geekbrains.team.tasktracker.controller;

import com.vtb.geekbrains.team.tasktracker.config.jwt.JwtTokenUtil;
import com.vtb.geekbrains.team.tasktracker.entity.User;
import com.vtb.geekbrains.team.tasktracker.entity.dto.JwtRequest;
import com.vtb.geekbrains.team.tasktracker.entity.dto.JwtResponse;
import com.vtb.geekbrains.team.tasktracker.entity.dto.RegisterRequest;
import com.vtb.geekbrains.team.tasktracker.errors.ApiError;
import com.vtb.geekbrains.team.tasktracker.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class AuthController {


    private final UserService userService;
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;


    @PostMapping("/signin")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        UserDetails userDetails = userService.loadUserByUsername(authRequest.getUsername());
        String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        User u = new User();
        u.setName(registerRequest.getName());
        u.setEmail(registerRequest.getEmail());
        u.setPassword(registerRequest.getPassword());
        try {
            userService.registerUser(u);
        }catch (Exception e){
            ApiError error = new ApiError(HttpStatus.BAD_REQUEST,e);
            return ResponseEntity.badRequest().body(error);
        }
        return ResponseEntity.ok("User succesfully registered");
    }


}
