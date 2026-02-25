package com.vti.SpringBoot.service;

import com.vti.SpringBoot.dto.request.AuthenticationRequest;
import com.vti.SpringBoot.dto.request.LoginRequest;
import com.vti.SpringBoot.exception.AppException;
import com.vti.SpringBoot.exception.ErrorCode;
import com.vti.SpringBoot.repository.UserRepository;
import com.vti.SpringBoot.security.JwtUtil;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {
    private UserRepository userRepository;

    private AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;

    public String login(LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        return jwtUtil.generateToken(loginRequest.getUsername());

    }

    public boolean authenticated(AuthenticationRequest res) {
        var user = userRepository.findByUsername(res.getUsername())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

        return passwordEncoder.matches(res.getPassword(), user.getPassword());
    }

    ;
}
