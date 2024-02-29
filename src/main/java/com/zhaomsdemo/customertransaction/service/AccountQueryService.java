package com.zhaomsdemo.customertransaction.service;

import com.zhaomsdemo.customertransaction.entity.Account;
import com.zhaomsdemo.customertransaction.repository.AccountRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountQueryService {

    final AccountRepository accountRepository;

    public Account getAccountById(String id) {
        return accountRepository.findById(id).get();
    }
}
