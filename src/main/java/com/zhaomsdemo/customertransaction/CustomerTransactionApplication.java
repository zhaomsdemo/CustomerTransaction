package com.zhaomsdemo.customertransaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableConfigurationProperties
@EnableMongoRepositories
@EnableDiscoveryClient
public class CustomerTransactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerTransactionApplication.class, args);
    }

}
