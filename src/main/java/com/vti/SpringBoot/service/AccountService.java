package com.vti.SpringBoot.service;

import com.vti.SpringBoot.entity.Account;
import com.vti.SpringBoot.repository.IAccountRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountService {
    IAccountRepository iAccountRepository;

    public List<Account> findByUsername(String userName) {
        return iAccountRepository.findByUsername(userName);
    }

    public Page<Account> findByUsernameLike(String userName, Pageable pageable) {
        return iAccountRepository.findByUsernameLike(userName, pageable);
    }
}
