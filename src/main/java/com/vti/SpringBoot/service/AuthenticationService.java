package com.vti.SpringBoot.service;

import com.vti.SpringBoot.dto.request.AuthenticationRequest;
import com.vti.SpringBoot.exception.AppException;
import com.vti.SpringBoot.exception.ErrorCode;
import com.vti.SpringBoot.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {
    UserRepository userRepository;

    public boolean authenticated(AuthenticationRequest res) {
        var user = userRepository.findByUsername(res.getUsername())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

        return passwordEncoder.matches(res.getPassword(), user.getPassword());
    }

    ;
}
