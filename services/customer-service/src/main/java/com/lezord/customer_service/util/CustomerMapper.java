package com.lezord.customer_service.util;

import com.lezord.customer_service.dto.request.CustomerRequestDTO;
import com.lezord.customer_service.dto.response.CustomerResponseDTO;
import com.lezord.customer_service.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CustomerMapper {

    public Customer toCustomer(CustomerRequestDTO request) {
        if (request == null) {
            return null;
        }
        return Customer.builder()
                .id(UUID.randomUUID().toString())
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .address(request.address())
                .build();
    }

    public CustomerResponseDTO fromCustomer(Customer customer) {
        if (customer == null) {
            return null;
        }
        return new CustomerResponseDTO(
                customer.getId(),
                customer.getFirstname(),
                customer.getLastname(),
                customer.getEmail(),
                customer.getAddress()
        );
    }

}
