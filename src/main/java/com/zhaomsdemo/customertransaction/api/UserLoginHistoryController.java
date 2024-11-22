package com.zhaomsdemo.customertransaction.api;

import com.zhaomsdemo.customertransaction.entity.UserInfo;
import com.zhaomsdemo.customertransaction.entity.UserLoginHistory;
import com.zhaomsdemo.customertransaction.repository.UserInfoRepository;
import com.zhaomsdemo.customertransaction.repository.UserLoginHistoryDao;
import com.zhaomsdemo.customertransaction.repository.UserLoginHistoryRepository;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/login")
public class UserLoginHistoryController {

    @Autowired
    private UserLoginHistoryDao userLoginHistoryDao;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private UserLoginHistoryRepository loginHistoryRepository;
    @Autowired
    private UserLoginHistoryRepository userLoginHistoryRepository;

    @GetMapping("/all")
    public List<Document> findAll() {
        List<Document> documents = userLoginHistoryDao.findAll();
        return documents;
    }

    @PostMapping("/import")
    public String importData() {
        loginHistoryRepository.deleteAll();
        userInfoRepository.deleteAll();
        prepareData();
        return "Success";
    }

    private void prepareData() {
        UserInfo userInfo1 = UserInfo.builder().id(UUID.randomUUID().toString())
                .userName("zjh").firstName("jh").lastName("zhao")
                .email("zjh123@gmail.com").address("1 A St")
                .phone("1234567890")
                .build();
        UserInfo userInfo2 = UserInfo.builder().id(UUID.randomUUID().toString())
                .userName("stmh").firstName("mh").lastName("st")
                .email("stmh123@gmail.com").address("2 A St")
                .phone("1234567891")
                .build();
        userInfoRepository.save(userInfo1);
        userInfoRepository.save(userInfo2);

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
        userLoginHistoryRepository.saveAll(userLoginHistories);
    }
}
