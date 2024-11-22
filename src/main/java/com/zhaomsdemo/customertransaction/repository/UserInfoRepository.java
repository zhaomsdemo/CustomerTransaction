package com.zhaomsdemo.customertransaction.repository;

import com.zhaomsdemo.customertransaction.entity.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends MongoRepository<UserInfo, String> {
}
