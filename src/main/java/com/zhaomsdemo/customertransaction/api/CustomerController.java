package com.zhaomsdemo.customertransaction.api;

import com.zhaomsdemo.customertransaction.dto.CustomerDto;
import com.zhaomsdemo.customertransaction.entity.Customer;
import com.zhaomsdemo.customertransaction.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/")
    public ResponseEntity<Customer> createNewCustomer(@RequestBody CustomerDto customerDto) {
        log.info("Creating a new customer: {}", customerDto);
        Customer newCustomer = customerService.saveCustomer(customerDto);
        return ResponseEntity.ok(newCustomer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String id) {
        log.info("Getting customer by id: {}", id);
        Customer customer = customerService.getCustomerById(id);
        log.info("Getting customer by id: {}", customer);
        return ResponseEntity.ok(customer);
    }
}
