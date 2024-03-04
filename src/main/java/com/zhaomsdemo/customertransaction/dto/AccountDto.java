package com.zhaomsdemo.customertransaction.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountDto {

    String id;
    Integer accountId;
    Integer limit;
    List<String> products;
}
