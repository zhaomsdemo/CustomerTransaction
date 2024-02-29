package com.zhaomsdemo.customertransaction.api;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.zhaomsdemo.customertransaction.entity.Account;
import com.zhaomsdemo.customertransaction.service.AccountQueryService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountQL implements GraphQLResolver<Account> {

    final AccountQueryService accountQueryService;

    @QueryMapping("accountById")
    public Account accountById(@Argument String id) {
        return accountQueryService.getAccountById(id);
    }
}
