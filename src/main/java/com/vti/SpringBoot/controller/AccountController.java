package com.vti.SpringBoot.controller;

import com.vti.SpringBoot.entity.Account;
import com.vti.SpringBoot.service.AccountService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("account")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountController {
    AccountService accountService;

    @GetMapping("/{userName}")
    public List<Account> findByUsername(@PathVariable("userName") String userName) {
        return accountService.findByUsername(userName);
    }

    @GetMapping("/name/{userName}")
    public Page<Account> findByUsernameLike(@PathVariable("userName") String userName, Pageable pageable) {
        return accountService.findByUsernameLike(userName, pageable);

    }
}
