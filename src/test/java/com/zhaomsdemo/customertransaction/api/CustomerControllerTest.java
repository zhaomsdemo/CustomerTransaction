package com.zhaomsdemo.customertransaction.api;

import com.zhaomsdemo.customertransaction.dto.CustomerDto;
import com.zhaomsdemo.customertransaction.entity.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.time.Instant;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerControllerTest {

    @Autowired
    private CustomerController customerController;

    @Test
    void testCreateAndFindCustomer() {
        ResponseEntity<Customer> response = customerController.createNewCustomer(createCustomerDto());
        assertNotNull(response);

        String id = response.getBody().getId();
        assertNotNull(id);

        ResponseEntity<Customer> findResponse = customerController.getCustomerById(id);
        assertNotNull(findResponse);
        assertNotNull(findResponse.getBody());
    }

    private CustomerDto createCustomerDto() {
        return CustomerDto.builder()
                .email("email@email.com")
                .name("name")
                .address("address")
                .accounts(new ArrayList<>())
                .active(true)
                .birthdate(Instant.now())
                .userName("userName")
                .tierAndDetails(new ArrayList<>())
                .build();
    }
}