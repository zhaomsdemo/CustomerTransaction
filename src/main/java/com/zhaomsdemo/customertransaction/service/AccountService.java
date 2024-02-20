package com.zhaomsdemo.customertransaction.service;

import com.zhaomsdemo.customertransaction.entity.Account;
import com.zhaomsdemo.customertransaction.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public List<Account> findByAccountId(Integer accountId) {
        return accountRepository.findByAccountIdEquals(accountId);
    }

    public Account findById(String id) {
        return accountRepository.findById(id).get();
    }
}
