package com.zhaomsdemo.customertransaction.repository;

import com.zhaomsdemo.customertransaction.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

    List<Account> findByAccountIdEquals(Integer accountId);
    Page<Account> findAll(Pageable pageable);
    Optional<Account> findById(String id);
}
