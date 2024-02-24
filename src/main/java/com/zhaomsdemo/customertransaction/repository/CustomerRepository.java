package com.zhaomsdemo.customertransaction.repository;

import com.zhaomsdemo.customertransaction.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
}
