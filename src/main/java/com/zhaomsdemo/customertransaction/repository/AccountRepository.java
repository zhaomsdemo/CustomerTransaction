package com.zhaomsdemo.customertransaction.repository;

import com.zhaomsdemo.customertransaction.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

    List<Account> findByAccountIdEquals(Integer accountId);

    Optional<Account> findById(String id);
}
