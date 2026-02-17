package com.vti.SpringBoot.service;

import com.vti.SpringBoot.dto.response.AccountReponse;
import com.vti.SpringBoot.entity.Account;
import com.vti.SpringBoot.mapper.AccountMapper;
import com.vti.SpringBoot.repository.IAccountRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.nio.channels.AcceptPendingException;
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

    public List<AccountReponse> getAllDTO() {
        return iAccountRepository.findAll()
                .stream()
                .map(AccountMapper::toDTO)
                .toList();
    }

    public AccountReponse getById(Integer id) {
        Account acc = iAccountRepository.findById((id))
                .orElseThrow(() -> new RuntimeException("Account not found"));

        return AccountMapper.toDTO(acc);
    }

    public AccountReponse getByUserName(String userName) {
        Account account = (Account) iAccountRepository.findByUsername(userName);
        return AccountMapper.toDTO(account);
    }


}
