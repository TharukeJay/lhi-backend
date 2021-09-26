package com.tharuke.lhi.service;

import com.tharuke.lhi.repository.CustomerRepository;
import com.tharuke.lhi.repository.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Map<String,Object> saveNewCustomer(Customer customer) {

        Map<String, Object> customerResponse = new HashMap<>();
        String status = "";

        boolean existById = customerRepository.existsCustomerByCustomerId(customer.getCustomerId());
        boolean existStatus = customerRepository.existsCustomerByCustomerName(customer.getCustomerName());

        if (existStatus) {
            status = "failed";
            customerResponse.put("result", status);
            customerResponse.put("message","Customer already exist");
        } else if(existById) {
            status = "failed";
            customerResponse.put("result", status);
            customerResponse.put("message","Customer already exist");
        } else {
            Customer savedCustomer = customerRepository.save(customer);

            if (savedCustomer.getId() == null) {
                status = "failed";
                customerResponse.put("result", status);
                customerResponse.put("message","Customer saving failed");
            } else {
                status = "success";
                customerResponse.put("result", status);
                customerResponse.put("message","Customer successfully saved");
            }
        }

        return customerResponse;
    }

    public Customer updateCustomer(String customerId, Customer customerParams) {
        Customer customer = customerRepository.findCustomerByCustomerId(customerId);
        customer.setAddress(customerParams.getAddress());
        customer.setContactNumber(customerParams.getContactNumber());
        customer.setCustomerName(customerParams.getCustomerName());
        customer.setTown(customerParams.getTown());
        Customer updatedCustomer = customerRepository.save(customer);
        return updatedCustomer;
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public List<Customer> searchCustomerByNameOrTown(String searchText) {
        return customerRepository.searchAllByCustomerNameAndTown(searchText, searchText);
    }

}
