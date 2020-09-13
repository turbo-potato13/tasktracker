package com.vtb.geekbrains.team.tasktracker.controller;

import com.vtb.geekbrains.team.tasktracker.config.jwt.JwtTokenUtil;
import com.vtb.geekbrains.team.tasktracker.entity.User;
import com.vtb.geekbrains.team.tasktracker.entity.dto.SignInRequest;
import com.vtb.geekbrains.team.tasktracker.entity.dto.SignInResponse;
import com.vtb.geekbrains.team.tasktracker.entity.dto.RegisterRequest;
import com.vtb.geekbrains.team.tasktracker.errors.ApiError;
import com.vtb.geekbrains.team.tasktracker.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class AuthController {


    private final UserService userService;
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager authenticationManager;


    @PostMapping("/signin")
    public ResponseEntity<?> createAuthToken(@RequestBody SignInRequest authRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
        UserDetails userDetails = userService.loadUserByUsername(authRequest.getEmail());
        String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new SignInResponse(token));
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
            log.error(e.toString());
            ApiError error = new ApiError(HttpStatus.BAD_REQUEST,e);
            return ResponseEntity.badRequest().body(error);
        }
        return ResponseEntity.ok("User succesfully registered");
    }


}
