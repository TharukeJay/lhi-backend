package com.tharuke.lhi.repository;

import com.tharuke.lhi.repository.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,String> {

    List<Customer> findAll();

    Customer findCustomerByCustomerId(String customerId);

    boolean existsCustomerByCustomerName(String customerName);
    boolean existsCustomerByCustomerId(String customerId);

    @Query("{'$or':[ {'customerName':{'$regex':?0, $options: 'i'}}, {'town':{'$regex':?1, $options: 'i'}} ] }")
    List<Customer> searchAllByCustomerNameAndTown(String customerName, String townText);

}
