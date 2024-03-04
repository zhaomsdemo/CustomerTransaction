package com.zhaomsdemo.customertransaction.util;

import com.zhaomsdemo.customertransaction.dto.AccountDto;
import com.zhaomsdemo.customertransaction.entity.Account;

public class AccountUtil {

    public static Account toNewAccount(AccountDto accountDto) {
        return Account.builder()
                .accountId(accountDto.getAccountId())
                .limit(accountDto.getLimit())
                .products(accountDto.getProducts())
                .build();
    }
}
