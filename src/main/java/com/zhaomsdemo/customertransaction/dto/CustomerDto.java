package com.zhaomsdemo.customertransaction.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class  CustomerDto {
    String id;
    String userName;
    String name;
    String address;
    String email;
    Boolean active;
    Instant birthdate;
    List<Integer> accounts;
    @JsonProperty("tier_and_details")
    List<TierAndDetailDto> tierAndDetails;

    @Data
    @Builder
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class TierAndDetailDto {
        String id;
        String tier;
        Boolean active;
        List<String> benefits;
    }
}


