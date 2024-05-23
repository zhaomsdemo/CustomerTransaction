package com.zhaomsdemo.customertransaction.api;

import com.zhaomsdemo.customertransaction.entity.Account;
import com.zhaomsdemo.customertransaction.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/all/{pageSize}/{pageNum}")
    public ResponseEntity<List<Account>> getAllAccounts(@PathVariable int pageNum,@PathVariable int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNum, pageSize);
        List<Account> accounts = accountService.findAll(pageRequest);
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/findByAccountId/{accountId}")
    public ResponseEntity<List<Account>>  findAccountListByAccountId(@PathVariable Integer accountId) {
        List<Account> accounts = accountService.findByAccountId(accountId);
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> findById(@PathVariable String id) {
        Account account = accountService.findById(id);
        return ResponseEntity.ok(account);
    }

    @PostMapping("/")
    public ResponseEntity<Account> createAccount(@RequestBody Account accountDto) {
        Account newAccount =  accountService.saveAccount(accountDto);
        return ResponseEntity.ok(newAccount);
    }
    @PutMapping("/")
    public ResponseEntity<Account> updateAccountLimit(@RequestBody  Account accountDto) {
        Account existingAccount = accountService.findById(accountDto.getId());
        if (existingAccount == null) {
            return ResponseEntity.notFound().build();
        }
        existingAccount = accountService.saveAccount(accountDto);
        return ResponseEntity.ok(existingAccount);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable String id) {
        Account existingAccount = accountService.findById(id);
        if (existingAccount == null) {
            return ResponseEntity.notFound().build();
        }
        accountService.deleteAccount(id);
        return ResponseEntity.ok().build();
    }
}