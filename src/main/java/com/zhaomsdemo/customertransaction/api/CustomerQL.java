package com.zhaomsdemo.customertransaction.api;

import com.zhaomsdemo.customertransaction.dto.CustomerDto;
import com.zhaomsdemo.customertransaction.entity.Customer;
import com.zhaomsdemo.customertransaction.service.CustomerQueryService;
import com.zhaomsdemo.customertransaction.util.CustomerUtil;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

//@Component
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerQL {

    final CustomerQueryService customerQueryService;

//    @QueryMapping
    public CustomerDto customerById(@Argument String id) {
        Customer customer = customerQueryService.findCustomerById(id);
        return CustomerUtil.toCustomerDto(customer);
    }

    @QueryMapping
    public List<CustomerDto> allCustomers() {
        List<Customer> customers = customerQueryService.findAllCustomers();
        return customers.stream().map(e -> CustomerUtil.toCustomerDto(e)).collect(Collectors.toList());
    }
}
