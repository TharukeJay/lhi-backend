package com.tharuke.lhi.controller;

import com.tharuke.lhi.repository.model.Customer;
import com.tharuke.lhi.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/api/customer")
@RestController
@CrossOrigin("*")
public class CustomerController {

    public CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/save")
    public ResponseEntity<Map<String,Object>> saveCustomer(@RequestBody Customer customer) {
        Map<String,Object> savedCustomer = customerService.saveNewCustomer(customer);
        return ResponseEntity.ok(savedCustomer);
    }

    @PutMapping("/update/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("customerId") String customerId, @RequestBody Customer customerParams) {
        Customer updatedCustomer = customerService.updateCustomer(customerId, customerParams);
        return ResponseEntity.ok(updatedCustomer);
    }

    @GetMapping("/allAgeGroups")
    public ResponseEntity<Map<String, Object>> getAllAgeGroupsAsList() {
        List<Customer> customers = customerService.getAllCustomers();

        Map<String, Object> pagedResponse = new HashMap<>();
        pagedResponse.put("customerList", customers);
        pagedResponse.put("rowCount", customers.size());
        return ResponseEntity.ok(pagedResponse);
    }

}
