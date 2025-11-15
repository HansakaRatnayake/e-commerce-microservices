package com.lezord.customer_service.service;


import com.lezord.customer_service.dto.request.CustomerRequestDTO;
import com.lezord.customer_service.dto.response.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {

    void create(CustomerRequestDTO request);

    void update(CustomerRequestDTO request, String id);

    List<CustomerResponseDTO> findAllCustomers();

    CustomerResponseDTO findById(String id);

    boolean existsById(String id);

    void deleteCustomer(String id);
}
