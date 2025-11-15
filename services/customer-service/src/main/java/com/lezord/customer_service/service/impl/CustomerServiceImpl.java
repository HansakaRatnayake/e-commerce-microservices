package com.lezord.customer_service.service.impl;

import com.lezord.customer_service.dto.request.CustomerRequestDTO;
import com.lezord.customer_service.dto.response.CustomerResponseDTO;
import com.lezord.customer_service.entity.Customer;
import com.lezord.customer_service.exception.CustomerNotFoundException;
import com.lezord.customer_service.repository.CustomerRepository;
import com.lezord.customer_service.service.CustomerService;
import com.lezord.customer_service.util.CustomerMapper;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;


    @Override
    public void create(CustomerRequestDTO request) {
        this.repository.save(mapper.toCustomer(request));
    }

    @Override
    public void update(CustomerRequestDTO request, String id) {
        var customer = this.repository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(
                        String.format("Cannot update customer:: No customer found with the provided ID: %s", id)
                ));
        mergeCustomer(customer, request);
    }

    @Override
    public List<CustomerResponseDTO> findAllCustomers() {
        return  this.repository.findAll()
                .stream()
                .map(this.mapper::fromCustomer)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerResponseDTO findById(String id) {
        return this.repository.findById(id)
                .map(mapper::fromCustomer)
                .orElseThrow(() -> new CustomerNotFoundException(String.format("No customer found with the provided ID: %s", id)));
    }

    @Override
    public boolean existsById(String id) {
        return this.repository.findById(id)
                .isPresent();
    }

    @Override
    public void deleteCustomer(String id) {
        this.repository.findById(id).orElseThrow(() -> new CustomerNotFoundException(String.format("No customer found with the provided ID: %s", id)));
        this.repository.deleteById(id);
    }


    private void mergeCustomer(Customer customer, CustomerRequestDTO request) {
        if (StringUtils.isNotBlank(request.firstname())) {
            customer.setFirstname(request.firstname());
        }
        if (StringUtils.isNotBlank(request.email())) {
            customer.setEmail(request.email());
        }
        if (request.address() != null) {
            customer.setAddress(request.address());
        }
    }
}
