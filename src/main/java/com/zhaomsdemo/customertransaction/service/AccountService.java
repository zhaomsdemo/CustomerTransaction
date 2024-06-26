package com.zhaomsdemo.customertransaction.service;

import com.zhaomsdemo.customertransaction.entity.Account;
import com.zhaomsdemo.customertransaction.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public List<Account> findAll(Pageable pageable) {
        return accountRepository.findAll(pageable).getContent();
    }

    public List<Account> findByAccountId(Integer accountId) {
        return accountRepository.findByAccountIdEquals(accountId);
    }

    public Account findById(String id) {
        return accountRepository.findById(id).get();
    }

    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    public void deleteAccount(String id) {
        accountRepository.deleteById(id);
    }
}
