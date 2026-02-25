package com.vti.SpringBoot.controller;

import com.vti.SpringBoot.dto.request.LoginRequest;
import com.vti.SpringBoot.dto.response.AuthResponse;
import com.vti.SpringBoot.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {

        // xác thực username & password
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        // tạo token
        String token = jwtUtil.generateToken(request.getUsername());

        return new AuthResponse(token);
    }
}