package com.zhaomsdemo.customertransaction.service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.zhaomsdemo.customertransaction.dto.CustomerDto;
import com.zhaomsdemo.customertransaction.entity.Customer;
import com.zhaomsdemo.customertransaction.repository.CustomerRepository;
import com.zhaomsdemo.customertransaction.util.CustomerUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer saveCustomer(CustomerDto customerDto) {
        Customer customer = CustomerUtil.toNewCustomer(customerDto);
        return customerRepository.save(customer);
    }

    public Customer getCustomerById(String id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        return customer;
    }
}
