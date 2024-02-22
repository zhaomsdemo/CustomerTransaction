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

import java.util.List;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(collection = "accounts")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Account {

    @Id
    String id;
    @Field(name = "account_id")
    @JsonProperty("account_id")
    Integer accountId;
    Integer limit;
    List<String> products;
}
