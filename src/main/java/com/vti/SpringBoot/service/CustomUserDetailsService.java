package com.vti.SpringBoot.service;

import com.vti.SpringBoot.entity.Account;
import com.vti.SpringBoot.repository.IAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private IAccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findAccountByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new User(
                account.getUserName(),
                account.getPassword(),
                Collections.emptyList()
        );
    }


}
