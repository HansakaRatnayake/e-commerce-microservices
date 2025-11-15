package com.lezord.customer_service.repository;

import com.lezord.customer_service.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository  extends MongoRepository<Customer, String> {
}
