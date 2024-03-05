package com.zhaomsdemo.customertransaction.api;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.zhaomsdemo.customertransaction.dto.AccountDto;
import com.zhaomsdemo.customertransaction.entity.Account;
import com.zhaomsdemo.customertransaction.service.AccountQueryService;
import com.zhaomsdemo.customertransaction.service.AccountService;
import com.zhaomsdemo.customertransaction.util.AccountUtil;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountQL implements GraphQLResolver<Account> {

    final AccountService accountService;

    @QueryMapping("accountById")
    public Account accountById(@Argument String id) {
        return accountService.findById(id);
    }

    @MutationMapping("createAccount")
    public Account createAccount(@Argument AccountDto accountDto) {
        Account account = AccountUtil.toNewAccount(accountDto);
        return accountService.saveAccount(account);
    }

    @MutationMapping("updateAccount")
    public Account updateAccount(@Argument String id, @Argument AccountDto accountDto) {
        Account account = AccountUtil.toUpdateAccount(id, accountDto);
        return accountService.saveAccount(account);
    }

    @MutationMapping("deleteAccount")
    public String deleteAccount(@Argument String id) {
        accountService.deleteAccount(id);
        return id;
    }
}
