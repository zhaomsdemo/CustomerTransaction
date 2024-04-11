package com.zhaomsdemo.customertransaction.api;

import com.zhaomsdemo.customertransaction.dto.CustomerDto;
import com.zhaomsdemo.customertransaction.entity.Customer;
import com.zhaomsdemo.customertransaction.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/")
    public ResponseEntity<Customer> createNewCustomer(@RequestBody CustomerDto customerDto) {
        Customer newCustomer = customerService.saveCustomer(customerDto);
        return ResponseEntity.ok(newCustomer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String id) {
        Customer customer = customerService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }
}
