package com.zhaomsdemo.customertransaction.service;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.zhaomsdemo.customertransaction.entity.Customer;
import com.zhaomsdemo.customertransaction.repository.CustomerRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CustomerQueryService implements GraphQLQueryResolver {

    final CustomerRepository customerRepository;

    public Customer findCustomerById(String id) {
        return customerRepository.findById(id).get();
    }

    public List<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }
}
