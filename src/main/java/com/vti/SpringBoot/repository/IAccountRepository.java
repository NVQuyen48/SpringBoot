package com.vti.SpringBoot.repository;

import com.vti.SpringBoot.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IAccountRepository extends JpaRepository<Account, Integer> {
    @Query("Select a from Account a where a.userName = :userName")
    List<Account> findByUsername(@Param("userName") String userName);

    @Query("select a from Account a where a.userName like  %?1%")
    Page<Account> findByUsernameLike(String userName, Pageable pageable);

    boolean existsAccountByUserName(String userName);

    Optional<Account> findAccountByUserName(String userName);
}
