package com.zhaomsdemo.customertransaction.repository;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.AddFieldsOperation;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.ConvertOperators;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserLoginHistoryDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Document> findAll() {
        AddFieldsOperation addFieldsOperation = AddFieldsOperation.addField("userObjectId")
                .withValue(ConvertOperators.ToObjectId.toObjectId("userId"))
                .build();
        LookupOperation lookupOperation = LookupOperation.newLookup().from("user_info")
                .localField("userId")
                .foreignField("_id")
                .as("userInfo");

        Aggregation aggregation = Aggregation.newAggregation(lookupOperation);
        return mongoTemplate.aggregate(aggregation, "user_login_history", Document.class).getMappedResults();
    }
}
