package com.zhaomsdemo.customertransaction.repository;

import com.zhaomsdemo.customertransaction.entity.UserInfo;
import com.zhaomsdemo.customertransaction.entity.UserLoginHistory;
import org.bson.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserLoginHistoryDaoTest {

    @Autowired
    private UserLoginHistoryDao userLoginHistoryDao;

    @Autowired
    private MongoTemplate mongoTemplate;

    @BeforeEach
    void setUp() {
        mongoTemplate.remove(new Query(), "user_login_history");
        mongoTemplate.remove(new Query(), "user_info");
    }

    @Test
    void findAll() {
        prepareData();
    }

    private void prepareData() {

        UserInfo userInfo1 = UserInfo.builder()
                .userName("zjh").firstName("jh").lastName("zhao")
                .email("zjh123@gmail.com").address("1 A St")
                .phone("1234567890")
                .build();
        UserInfo userInfo2 = UserInfo.builder()
                .userName("stmh").firstName("mh").lastName("st")
                .email("stmh123@gmail.com").address("2 A St")
                .phone("1234567891")
                .build();
        mongoTemplate.save(userInfo1);
        mongoTemplate.save(userInfo2);

        assertNotNull(userInfo1.getId());
        assertNotNull(userInfo2.getId());

        List<UserLoginHistory> userLoginHistories = List.of(
                UserLoginHistory.builder().userId(userInfo1.getId()).loginIp("192.168.1.1").loginLocation("local")
                        .loginTime(Instant.now().toString()).build(),
                UserLoginHistory.builder().userId(userInfo1.getId()).loginIp("192.168.1.1").loginLocation("local")
                        .loginTime(Instant.now().toString()).build(),
                UserLoginHistory.builder().userId(userInfo1.getId()).loginIp("192.168.1.1").loginLocation("local")
                        .loginTime(Instant.now().toString()).build(),
                UserLoginHistory.builder().userId(userInfo1.getId()).loginIp("192.168.1.1").loginLocation("local")
                        .loginTime(Instant.now().toString()).build(),
                UserLoginHistory.builder().userId(userInfo2.getId()).loginIp("192.168.1.2").loginLocation("local")
                        .loginTime(Instant.now().toString()).build(),
                UserLoginHistory.builder().userId(userInfo2.getId()).loginIp("192.168.1.2").loginLocation("local")
                        .loginTime(Instant.now().toString()).build(),
                UserLoginHistory.builder().userId(userInfo2.getId()).loginIp("192.168.1.2").loginLocation("local")
                        .loginTime(Instant.now().toString()).build()
        );

        mongoTemplate.insertAll(userLoginHistories);
        assertNotNull(userLoginHistories);

        List<Document> documents = userLoginHistoryDao.findAll();
        assertNotNull(documents);
    }
}