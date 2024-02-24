package com.zhaomsdemo.customertransaction.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "customers")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Customer {

    @Id
    String id;
    @Field(name = "username")
    @JsonProperty("username")
    String userName;
    String name;
    String address;
    String email;
    Boolean active;
    Instant birthdate;
    List<Integer> accounts;
    @Field(name = "tier_and_details")
    @JsonProperty("tier_and_details")
    Map<String, TierAndDetail> tierAndDetails;

    @Data
    @Builder
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class TierAndDetail {
        String id;
        String tier;
        Boolean active;
        List<String> benefits;
    }
}
