package com.lezord.customer_service.controller;

import com.lezord.customer_service.dto.request.CustomerRequestDTO;
import com.lezord.customer_service.service.CustomerService;
import com.lezord.customer_service.util.StandardResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
class CustomerController {

    private final CustomerService service;

    @PostMapping
    public ResponseEntity<StandardResponseDTO> createCustomer(
            @RequestBody @Valid CustomerRequestDTO request
    ) {
        this.service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new StandardResponseDTO(201, "Customer created successfully", null)
        );
    }

    @PutMapping("/{customer-id}")
    public ResponseEntity<StandardResponseDTO> updateCustomer(
            @RequestBody @Valid CustomerRequestDTO request,
            @PathVariable("customer-id") String customerId
    ) {
        this.service.update(request, customerId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                new StandardResponseDTO(202, "Customer updated successfully", null)
        );
    }

    @GetMapping
    public ResponseEntity<StandardResponseDTO> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(
                new StandardResponseDTO(200, "Customers found", this.service.findAllCustomers())
        );
    }

    @GetMapping("/exists/{customer-id}")
    public ResponseEntity<StandardResponseDTO> existsById(
            @PathVariable("customer-id") String customerId
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new StandardResponseDTO(200, "Customer found",this.service.existsById(customerId))
        );
    }

    @GetMapping("/{customer-id}")
    public ResponseEntity<StandardResponseDTO> findById(
            @PathVariable("customer-id") String customerId
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(
                new StandardResponseDTO(200, "Customer found",this.service.findById(customerId))
        );
    }

    @DeleteMapping("/{customer-id}")
    public ResponseEntity<StandardResponseDTO> delete(
            @PathVariable("customer-id") String customerId
    ) {
        this.service.deleteCustomer(customerId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                new StandardResponseDTO(204, "Customer found",null)
        );
    }
}
