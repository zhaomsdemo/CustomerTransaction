package com.zhaomsdemo.customertransaction.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.zhaomsdemo.customertransaction.config.UuidGenerator;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "user_info")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserInfo {

    @Id
    String id;
    String userName;
    String firstName;
    String lastName;
    String email;
    String phone;
    String address;
    @CreatedDate
    Instant createdOn;
}
