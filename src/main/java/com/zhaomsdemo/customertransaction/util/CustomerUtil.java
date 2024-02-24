package com.zhaomsdemo.customertransaction.util;

import com.zhaomsdemo.customertransaction.dto.CustomerDto;
import com.zhaomsdemo.customertransaction.entity.Customer;

import java.util.UUID;
import java.util.stream.Collectors;

public class CustomerUtil {

    public static Customer toNewCustomer(CustomerDto customerDto) {
        Customer customer = Customer.builder()
                .email(customerDto.getEmail())
                .name(customerDto.getName())
                .userName(customerDto.getUserName())
                .active(customerDto.getActive())
                .address(customerDto.getAddress())
                .birthdate(customerDto.getBirthdate())
                .accounts(customerDto.getAccounts())
                .tierAndDetails(customerDto.getTierAndDetails().stream()
                        .map(tierAndDetailDto -> {
                            tierAndDetailDto.setId(UUID.randomUUID().toString());
                            return tierAndDetailDto;
                        })
                        .collect(Collectors.toMap(CustomerDto.TierAndDetailDto::getId,
                                e -> Customer.TierAndDetail.builder()
                                .id(e.getId())
                                .active(e.getActive())
                                .benefits(e.getBenefits())
                                .tier(e.getTier())
                                .build())))
                .build();
        return customer;
    }
}
