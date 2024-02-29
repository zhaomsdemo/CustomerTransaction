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

    public static CustomerDto toCustomerDto(Customer customer) {
        CustomerDto customerDto = CustomerDto.builder()
                .email(customer.getEmail())
                .name(customer.getName())
                .userName(customer.getUserName())
                .active(customer.getActive())
                .address(customer.getAddress())
                .birthdate(customer.getBirthdate())
                .accounts(customer.getAccounts())
                .tierAndDetails(customer.getTierAndDetails().values()
                        .stream().map(
                                tierAndDetail -> CustomerDto.TierAndDetailDto.builder()
                                        .id(tierAndDetail.getId())
                                        .tier(tierAndDetail.getTier())
                                        .active(tierAndDetail.getActive())
                                        .benefits(tierAndDetail.getBenefits())
                                        .build()
                        ).collect(Collectors.toList()))
                .build();
        return customerDto;
    }
}
