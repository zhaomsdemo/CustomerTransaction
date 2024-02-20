package com.zhaomsdemo.customertransaction.api;

import com.zhaomsdemo.customertransaction.entity.Account;
import com.zhaomsdemo.customertransaction.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/findByAccountId/{accountId}")
    public List<Account>  findAccountListByAccountId(@PathVariable Integer accountId) {
        List<Account> accounts = accountService.findByAccountId(accountId);
        return accounts;
    }

    @GetMapping("/{id}")
    public Account findById(@PathVariable String id) {
        return accountService.findById(id);
    }
}
