package com.zhaomsdemo.customertransaction.repository;

import com.zhaomsdemo.customertransaction.entity.UserLoginHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLoginHistoryRepository extends MongoRepository<UserLoginHistory, String> {
}
