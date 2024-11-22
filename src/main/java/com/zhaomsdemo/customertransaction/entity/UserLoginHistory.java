package com.zhaomsdemo.customertransaction.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "user_login_history")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserLoginHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String userId;
    String loginTime;
    String loginIp;
    String loginLocation;
    @CreatedDate
    Instant createdOn;
}
